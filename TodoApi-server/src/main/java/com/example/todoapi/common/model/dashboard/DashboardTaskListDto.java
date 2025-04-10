package com.example.todoapi.common.model.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.todoapi.common.model.task.TaskDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * ピン留めされたタスクのリスト
 */

@Schema(name = "DashboardTaskListDto", description = "ピン留めされたタスクのリスト")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-09T16:11:38.259152900+09:00[Asia/Tokyo]")
public class DashboardTaskListDto {

  @JsonProperty("results")
  @Valid
  private List<TaskDto> results = new ArrayList<>();

  public DashboardTaskListDto results(List<TaskDto> results) {
    this.results = results;
    return this;
  }

  public DashboardTaskListDto addResultsItem(TaskDto resultsItem) {
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
    DashboardTaskListDto dashboardTaskListDto = (DashboardTaskListDto) o;
    return Objects.equals(this.results, dashboardTaskListDto.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardTaskListDto {\n");
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

