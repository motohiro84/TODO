package com.example.todoapi.common.model.task;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * TaskPinDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-23T16:08:02.882395400+09:00[Asia/Tokyo]")
public class TaskPinForm {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("pinF")
  private Integer pinF;

  public TaskPinForm id(Long id) {
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

  public TaskPinForm pinF(Integer pinF) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskPinForm taskPinDto = (TaskPinForm) o;
    return Objects.equals(this.id, taskPinDto.id) &&
        Objects.equals(this.pinF, taskPinDto.pinF);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pinF);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskPinDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

