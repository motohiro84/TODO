package com.example.todoapi.common.model.task;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * TaskDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-23T16:08:02.882395400+09:00[Asia/Tokyo]")
public class TaskDto {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("content")
  private String content;

  @JsonProperty("compF")
  private Integer compF;

  @JsonProperty("pinF")
  private Integer pinF;

  public TaskDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * タスクID
   * @return id
  */
  @NotNull
  @Schema(name = "id", description = "タスクID", requiredMode = Schema.RequiredMode.REQUIRED)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TaskDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * タスクのタイトル
   * @return title
  */
  @NotNull
  @Schema(name = "title", description = "タスクのタイトル", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TaskDto content(String content) {
    this.content = content;
    return this;
  }

  /**
   * タスクの内容
   * @return content
  */

  @Schema(name = "content", description = "タスクの内容", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public TaskDto compF(Integer compF) {
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

  public TaskDto pinF(Integer pinF) {
    this.pinF = pinF;
    return this;
  }

  /**
   * タスクのピン留めフラグ
   * @return pinF
  */
  @Schema(name = "pinF", description = "タスクのピン留めフラグ", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getPinF() {
    return pinF;
  }

  public void setPinF(Integer pinF) {
    this.pinF = pinF;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDto taskDto = (TaskDto) o;
    return Objects.equals(this.id, taskDto.id) &&
        Objects.equals(this.title, taskDto.title) &&
        Objects.equals(this.content, taskDto.content) &&
        Objects.equals(this.compF, taskDto.compF) &&
        Objects.equals(this.pinF, taskDto.pinF);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, content, compF, pinF);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    compF: ").append(toIndentedString(compF)).append("\n");
    sb.append("    pinF: ").append(toIndentedString(pinF)).append("\n");
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

