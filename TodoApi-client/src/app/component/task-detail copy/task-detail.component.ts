import { Component, OnInit, Input, Inject, Injectable } from '@angular/core';
import { TaskDto, TaskUpdateForm } from '../../dto/task-dto';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../../service/task.service';
import { Location } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogRef, MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {
  @Input() task: TaskDto;
  compF: string;

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService,
    private location: Location,
    public dialogRef: MatDialogRef<TaskDetailComponent>,
    @Inject(MAT_DIALOG_DATA) public taskId: number
  ) { }

  ngOnInit(): void {
    this.getTask(this.taskId);
  }

  getTask(taskId: number): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.taskService.getTask(taskId)
      .subscribe(response => {
        this.task = response;
        this.compF = this.task.compF.toString();
      });
  }

  setTask(response: TaskDto): void {
    this.task = response
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.setCompF(this.compF)

    this.taskService.updateTask(this.task)
      .subscribe(() => this.goBack());
  }

  private setCompF(compF: string): void {
    this.task.compF = parseInt(compF);
  }
}
