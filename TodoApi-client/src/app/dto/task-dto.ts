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
  compDate: Date;
  pinF: number;
  imageUrl: string;
}

export interface TaskCreateForm {
  title: string;
  content: string;
  compDate: Date;
}

export interface TaskUpdateForm {
  title: string;
  content: string;
  compDate: Date;
  compF: number;
}

export interface TaskPinForm {
  id: number;
  pinF: number;
}

export interface DashboardTaskListDto {
  results: TaskDto[];
}