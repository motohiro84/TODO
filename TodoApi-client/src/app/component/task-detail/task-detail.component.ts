import { Component, OnInit, Input, Inject, Output, EventEmitter  } from '@angular/core';
import { TaskDto } from '../../dto/task-dto';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../../service/task.service';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {
  @Input() task: TaskDto = { id: null, title: '', content: '', compF: 0, pinF: 0};
  @Output() updateTasks: EventEmitter<any> = new EventEmitter();
  compF: string;
  isNew: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService,
    public dialogRef: MatDialogRef<TaskDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { taskId: number }
  ) { }

  ngOnInit(): void {
    if (this.data?.taskId) {
      this.isNew = false;
      this.getTask();
    } else {
      this.isNew = true;
    }
  }

  getTask(): void {
    const id = this.data?.taskId || +this.route.snapshot.paramMap.get('id');
    this.taskService.getTask(id)
      .subscribe(response => {
        this.task = response;
        this.compF = this.task.compF.toString();
      });
  }

  setTask(response: TaskDto): void {
    this.task = response
  }

  save(): void {
    this.task.compF = parseInt(this.compF);
    if (this.isNew) {
      this.taskService.addTask(this.task).subscribe(() => {
        this.updateTasks.emit();
        this.closeModal();
      });
    } else {
      this.taskService.updateTask(this.task).subscribe(() => {
        this.updateTasks.emit();
        this.closeModal();
      });
    }
  }

  // ダイアログを閉じる
  closeModal() {
    this.dialogRef.close();
  }

}
