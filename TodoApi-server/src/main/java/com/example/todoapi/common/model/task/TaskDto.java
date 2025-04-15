package com.example.todoapi.common.model.task;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * TaskDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-11T17:44:46.398008100+09:00[Asia/Tokyo]")
public class TaskDto {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("content")
  private String content;

  @JsonProperty("compF")
  private Integer compF;

  @JsonProperty("compDate")
  private LocalDate compDate = null;

  @JsonProperty("pinF")
  private Integer pinF;

  @JsonProperty("imageUrl")
  private String imageUrl;

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

  public TaskDto compDate(LocalDate compDate) {
    this.compDate = compDate;
    return this;
  }

  /**
   * タスクの完了期限
   * @return compDate
  */
  @NotNull @Valid
  @Schema(name = "compDate", description = "タスクの完了期限", requiredMode = Schema.RequiredMode.REQUIRED)
  public LocalDate getCompDate() {
    return compDate;
  }

  public void setCompDate(LocalDate date) {
    this.compDate = date;
  }

  public TaskDto pinF(Integer pinF) {
    this.pinF = pinF;
    return this;
  }

  /**
   * タスクのピン留めフラグ
   * @return pinF
  */
  @NotNull
  @Schema(name = "pinF", description = "タスクのピン留めフラグ", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getPinF() {
    return pinF;
  }

  public void setPinF(Integer pinF) {
    this.pinF = pinF;
  }

  public TaskDto imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  /**
   * タスク成果物
   * @return imageUrl
  */
  @NotNull
  @Schema(name = "imageUrl", description = "タスク成果物", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
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
        Objects.equals(this.compDate, taskDto.compDate) &&
        Objects.equals(this.pinF, taskDto.pinF) &&
        Objects.equals(this.imageUrl, taskDto.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, content, compF, compDate, pinF, imageUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    compF: ").append(toIndentedString(compF)).append("\n");
    sb.append("    compDate: ").append(toIndentedString(compDate)).append("\n");
    sb.append("    pinF: ").append(toIndentedString(pinF)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
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

