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

  getDeadlineColor(compDate: string | Date): string {
    if (!compDate) return 'black';
    const today = new Date();
    today.setHours(0, 0, 0, 0); // 今日の0時
    const deadline = new Date(compDate);
    deadline.setHours(0, 0, 0, 0); // 期限も0時に揃える

    // 期日が過ぎている
    if (deadline.getTime() < today.getTime()) return 'red';

    // 3日以内
    const threeDaysLater = new Date(today);
    threeDaysLater.setDate(today.getDate() + 3);
    if (deadline.getTime() <= threeDaysLater.getTime()) return 'orange';

    // それ以外
    return 'black';
  }

}
