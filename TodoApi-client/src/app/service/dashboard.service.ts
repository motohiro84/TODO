import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { DashboardTaskListDto } from '../dto/task-dto';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  private baseUrl = environment.apiBaseUrl;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    private messageService: MessageService
  ) { }

  getTasks(): Observable<DashboardTaskListDto> {

    let url: string = `${this.baseUrl}/dashboard/`;

    return this.http.get<DashboardTaskListDto>(url)
      .pipe(
        tap(tasks => this.log('社員データを取得しました')),
        catchError(this.handleError<DashboardTaskListDto>())
      );
  }

  private log(message: string) {
    this.messageService.add(`DashboardService: ${message}`);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);

      this.log(`${operation} 失敗: ${error.message}`);

      return of(result as T);
    }
  }
}
