export interface TaskListDto {
  page: PageDto;
  results: TaskDto[];
}

export interface PageDto {
  limit: number;
  offset: number;
  size: number;
}

export interface TaskDto {
  id: number;
  title: string;
  content: string;
  compF: number;
  pinF: number;
}

export interface TaskCreateForm {
  title: string;
  content: string;
}

export interface TaskUpdateForm {
  title: string;
  content: string;
  compF: number;
}

export interface TaskPinForm {
  id: number;
  pinF: number;
}

export interface DashboardTaskListDto {
  results: TaskDto[];
}