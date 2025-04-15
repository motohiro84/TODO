package com.example.todoapi.common.model.task;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * TaskCreateForm
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-15T14:31:13.750543900+09:00[Asia/Tokyo]")
public class TaskCreateForm {

  @JsonProperty("title")
  private String title;

  @JsonProperty("content")
  private String content;

  @JsonProperty("compDate")
  private LocalDate compDate = null;

  public TaskCreateForm title(String title) {
    this.title = title;
    return this;
  }

  /**
   * 作成されるタスクのタイトル
   * @return title
  */
  @NotNull @Size(min = 1, max = 12)
  @Schema(name = "title", description = "作成されるタスクのタイトル", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TaskCreateForm content(String content) {
    this.content = content;
    return this;
  }

  /**
   * タスクの内容
   * @return content
  */
  @Size(max = 160)
  @Schema(name = "content", description = "タスクの内容", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public TaskCreateForm compDate(LocalDate compDate) {
    this.compDate = compDate;
    return this;
  }

  /**
   * タスクの完了期限
   * @return compDate
  */
  @Valid
  @Schema(name = "compDate", description = "タスクの完了期限", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public LocalDate getCompDate() {
    return compDate;
  }

  public void setCompDate(LocalDate compDate) {
    this.compDate = compDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskCreateForm taskCreateForm = (TaskCreateForm) o;
    return Objects.equals(this.title, taskCreateForm.title) &&
        Objects.equals(this.content, taskCreateForm.content) &&
        Objects.equals(this.compDate, taskCreateForm.compDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, content, compDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskCreateForm {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    compDate: ").append(toIndentedString(compDate)).append("\n");
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

