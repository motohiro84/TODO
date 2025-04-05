import { Injectable } from '@angular/core';
import { TaskDto, TaskCreateForm, TaskUpdateForm, TaskListDto, TaskPinForm } from '../dto/task-dto';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private baseUrl = 'http://localhost:8080';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  updateForm: TaskUpdateForm;

  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) { }

  getTasks(title?: string): Observable<TaskListDto> {

    let url: string = `${this.baseUrl}/tasks/`;

    if (!!title) {
      url += `?title=${title}`
    }

    return this.http.get<TaskListDto>(url)
      .pipe(
        tap(tasks => this.log('社員データを取得しました')),
        catchError(this.handleError<TaskListDto>())
      );
  }

  getTask(id: number): Observable<TaskDto> {
    const url = `${this.baseUrl}/tasks/${id} `;
    return this.http.get<TaskDto>(url)
      .pipe(
        tap(_ => this.log(`社員データ(id = ${id})を取得しました`)),
        catchError(this.handleError<TaskDto>(`getTask id = ${id} `))
      );
  }

  updateTask(task: TaskDto): Observable<any> {

    this.setTaskForm(task);

    return this.http.put(`${this.baseUrl}/tasks/${task.id} `, this.updateForm, this.httpOptions)
      .pipe(
        tap(_ => this.log(`社員データ(id = ${task.id})を変更しました`)),
        catchError(this.handleError<any>('updateTask'))
      );
  }

  addTask(task: TaskCreateForm): Observable<TaskDto> {
    return this.http.post<TaskDto>(`${this.baseUrl}/tasks/`, task, this.httpOptions)
      .pipe(
        tap((newTask: TaskDto) => this.log(`社員データ(id = ${newTask.id})を追加しました`)),
        catchError(this.handleError<TaskDto>('addTask'))
      );
  }

  deleteTask(task: TaskDto | number): Observable<TaskDto> {
    const id = typeof task === 'number' ? task : task.id;
    const url = `${this.baseUrl}/tasks/${id} `;

    return this.http.delete<TaskDto>(url, this.httpOptions)
      .pipe(
        tap(_ => this.log(`社員データ(id = ${id})を削除しました`)),
        catchError(this.handleError<TaskDto>('deleteTask'))
      );
  }

  pinnedTask(taskPin: TaskPinForm): Observable<TaskDto> {

    return this.http.put<TaskDto>(`${this.baseUrl}/tasks/`, taskPin, this.httpOptions)
      .pipe(
        tap(_ => this.log(`タスクデータ(id = ${taskPin.id})のピン留めを更新しました`)),
        catchError(this.handleError<TaskDto>('pinnedTask'))
      );
  }

  searchTasks(term: string): Observable<TaskDto[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<TaskDto[]>(`${this.baseUrl}/?title=${term}`)
      .pipe(
        tap(_ => this.log(`${term} にマッチする社員データが見つかりました`)),
        catchError(this.handleError<TaskDto[]>('searchTask', []))
      );
  }

  private setTaskForm(task: TaskDto) {
    this.updateForm = {
      title: task.title,
      content: task.content,
      compF: task.compF
    };
  }

  private log(message: string) {
    this.messageService.add(`TaskService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      this.log(`${operation} 失敗: ${error.message}`);

      return of(result as T);
    }
  }
}
