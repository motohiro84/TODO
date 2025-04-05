import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { TaskDto, TaskListDto } from '../../dto/task-dto';
import { TaskService } from '../../service/task.service';
import { debounceTime, distinctUntilChanged, switchMap, tap } from 'rxjs/operators';

@Component({
  selector: 'app-task-search',
  templateUrl: './task-search.component.html',
  styleUrls: ['./task-search.component.css']
})
export class TaskSearchComponent implements OnInit {
  tasks$: Observable<TaskDto[]>;
  private searchTerms = new Subject<string>();

  @Output() searchList = new EventEmitter<TaskListDto>();

  constructor(private taskService: TaskService) { }

  search(title: string): void {
    this.taskService.getTasks(title) // Observable
      .subscribe(response => this.searchList.emit(response));
  }

  ngOnInit(): void {
    this.tasks$ = this.searchTerms.pipe(
      // キーボード入力の後、300ms待って次の実行に移る
      debounceTime(300),

      // 直前のデータと同じ場合は処理を実行しない
      distinctUntilChanged(),

      // 検索キーワードを受け取る度に、新しいObservableを返す
      switchMap((term: string) => this.taskService.searchTasks(term))
    );
  }

}
