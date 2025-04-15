import { Component } from '@angular/core';
import { TaskDto, TaskListDto, TaskCreateForm, TaskPinForm } from '../../dto/task-dto';
import { TaskService } from '../../service/task.service';
import { MessageService } from '../../service/message.service';
import { NgForm } from '@angular/forms';

import { MatDialog, MatDialogRef, MatDialogConfig } from '@angular/material/dialog';
import { TaskDetailComponent } from '../task-detail/task-detail.component';
import { ConfirmationComponent } from '../confirmation//confirmation.component';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent {

  tasks: TaskDto[];
  disptasks: TaskDto[];
  dispF: string = "0";
  taskForm: TaskCreateForm = { title: '', content: '', compDate: null };
  dialogRef: MatDialogRef<any>;

  constructor(
    private taskService: TaskService,
    public _matdialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks(): void {
    this.taskService.getTasks() // Observable
      .subscribe(response => {
        this.setTasks(response);
      });
  }

  setTasks(response: TaskListDto): void {
    this.tasks = [...response.results];
    this.displayTask();
  }

  add(form: NgForm): void {
    this.taskForm.title = form.value.title.trim();
    this.taskForm.content = form.value.content.trim();
    if (!form.value.title) { return; }
    this.taskService.addTask(this.taskForm)
      .subscribe(task => {
        this.tasks.push(task);
      });
  }

  delete(task: TaskDto): void {
    this.tasks = this.tasks.filter(m => m !== task);
    this.taskService.deleteTask(task).subscribe(() => {
      this.displayTask();
    });
  }

  pinnedTask(task: TaskDto): void {
    const taskForm: TaskPinForm = {
      id: task.id,
      pinF: task.pinF === 0 ? 1 : 0
    };
    this.taskService.pinnedTask(taskForm).subscribe((res: TaskDto) => {
      const newTask = this.tasks.find(e => e.id == res.id);
      if (newTask) {
        newTask.pinF = res.pinF;
      }
      this.displayTask();
    });
  }

  displayTask(): void {
    if (this.dispF == "0") {
      this.disptasks = this.tasks;
    } else if (this.dispF == "1") {
      this.disptasks = this.tasksChange(0);
    } else if (this.dispF == "2") {
      this.disptasks = this.tasksChange(1);
    }
  }

  tasksChange(compF: number): TaskDto[] {
    let changeTasks: TaskDto[] = [];
    for (let task of this.tasks) {
      if (task.compF == compF) {
        changeTasks.push(task);
      }
    }
    return changeTasks;
  }

  openTaskModal(taskId: number | null) {

    this.dialogRef = this._matdialog.open(TaskDetailComponent, {
      // 表示するdialogの設定
      disableClose : true,
      id : "panel",
      height : "280px",
      width : "550px",
      panelClass: "custom-dialog-container",
      data : { taskId: taskId},
      position : { left: "32%", top: "20%"},
      ariaModal : true
    });

    // ダイアログが閉じられた後にオーバーレイを非表示にする
    this.dialogRef.afterClosed().subscribe(() => {
      this.setOverlay(false);
    });

    this.dialogRef.componentInstance.updateTasks.subscribe(() => {
      this.getTasks();
    });

    // ダイアログを開くときにオーバーレイを表示
    this.setOverlay(true);
  }

  setOverlay(ishidden: boolean){
    if (ishidden) {
      // ダイアログを開くときにオーバーレイを表示
      let overlay = document.getElementsByClassName('cdk-overlay-container');
      if (overlay && overlay.length > 0) {
        overlay[0].removeAttribute('hidden');  // hidden属性を削除して表示する
      }
    } else {
    // ダイアログが閉じられた後にオーバーレイを非表示にする
    let overlay = document.getElementsByClassName('cdk-overlay-container');
      if (overlay && overlay.length > 0) {
        overlay[0].setAttribute('hidden', 'true');  // hidden属性を追加して非表示にする
      }
    }
  }

  getPinBtnClass(pinF: string): string {
    if (pinF == "1"){
      return 'pin check';
    } else {
      return 'pin nothing';
    }
  }

  openConfirmationModal(task: TaskDto) {

    this.dialogRef = this._matdialog.open(ConfirmationComponent, {
      // 表示するdialogの設定
      disableClose : true,
      id : "panel",
      height : "233.8px",
      width : "500px",
      panelClass: "custom-dialog-container",
      position : { left: "32%", top: "20%"},
      ariaModal : true
    });

    // ダイアログが閉じられた後にオーバーレイを非表示にする
    this.dialogRef.afterClosed().subscribe(() => {
      this.setOverlay(false);
    });

    // ダイアログを開くときにオーバーレイを表示
    this.setOverlay(true);

    this.dialogRef.componentInstance.onClose.subscribe(flg => {
      if (flg) {
        this.delete(task);
      }
    });
  }

}
