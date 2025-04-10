import { Component, OnInit } from '@angular/core';
import { TaskDto, DashboardTaskListDto } from '../../dto/task-dto';
import { DashboardService } from '../../service/dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  tasks: TaskDto[] = [];

  constructor(private dashboardService: DashboardService) { }

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks(): void {
    this.dashboardService.getTasks()
      .subscribe(response => {
        this.setTasks(response);
      });
  }

  setTasks(response: DashboardTaskListDto): void {
    this.tasks = [...response.results];
  }

}
