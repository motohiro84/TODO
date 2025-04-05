package com.example.todoapi.common.model.task;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * TaskUpdateForm
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-24T11:29:35.113097400+09:00[Asia/Tokyo]")
public class TaskUpdateForm {

  @JsonProperty("title")
  private String title;

  @JsonProperty("content")
  private String content;

  @JsonProperty("compF")
  private Integer compF;

  public TaskUpdateForm title(String title) {
    this.title = title;
    return this;
  }

  /**
   * 作成されるタスクのタイトル
   * @return title
  */
  @NotNull @Size(min = 1, max = 256)
  @Schema(name = "title", description = "作成されるタスクのタイトル", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TaskUpdateForm content(String content) {
    this.content = content;
    return this;
  }

  /**
   * タスクの内容
   * @return content
  */
  @Size(max = 256)
  @Schema(name = "content", description = "タスクの内容", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public TaskUpdateForm compF(Integer compF) {
    this.compF = compF;
    return this;
  }

  /**
   * タスクの完了フラグ
   * @return compF
  */
  @NotNull
  @Schema(name = "compF", description = "タスクの完了フラグ", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getCompF() {
    return compF;
  }

  public void setCompF(Integer compF) {
    this.compF = compF;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskUpdateForm taskUpdateForm = (TaskUpdateForm) o;
    return Objects.equals(this.title, taskUpdateForm.title) &&
        Objects.equals(this.content, taskUpdateForm.content) &&
        Objects.equals(this.compF, taskUpdateForm.compF);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, content, compF);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskUpdateForm {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    compF: ").append(toIndentedString(compF)).append("\n");
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

