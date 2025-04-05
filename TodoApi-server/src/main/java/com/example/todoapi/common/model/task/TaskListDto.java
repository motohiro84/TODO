package com.example.todoapi.common.model.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.todoapi.common.model.common.PageDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * タスクのリスト
 */

@Schema(name = "TaskListDTO", description = "タスクのリスト")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T08:54:47.507584900+09:00[Asia/Tokyo]")
public class TaskListDto {

  @JsonProperty("page")
  private PageDto page;

  @JsonProperty("results")
  @Valid
  private List<TaskDto> results = new ArrayList<>();

  public TaskListDto page(PageDto page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  */
  @Valid
  @Schema(name = "page", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public PageDto getPage() {
    return page;
  }

  public void setPage(PageDto page) {
    this.page = page;
  }

  public TaskListDto results(List<TaskDto> results) {
    this.results = results;
    return this;
  }

  public TaskListDto addResultsItem(TaskDto resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  */
  @NotNull @Valid
  @Schema(name = "results", requiredMode = Schema.RequiredMode.REQUIRED)
  public List<TaskDto> getResults() {
    return results;
  }

  public void setResults(List<TaskDto> results) {
    this.results = results;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskListDto taskListDTO = (TaskListDto) o;
    return Objects.equals(this.page, taskListDTO.page) &&
        Objects.equals(this.results, taskListDTO.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskListDTO {\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

