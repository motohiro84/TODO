package com.example.todoapi.common.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * 指定したリソースが存在しない
 */

@Schema(name = "ResourceNotFoundError", description = "指定したリソースが存在しない")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T08:54:47.507584900+09:00[Asia/Tokyo]")
public class ResourceNotFoundError {

  @JsonProperty("title")
  private String title = "Resource Not Found";

  @JsonProperty("detail")
  private String detail;

  public ResourceNotFoundError title(String title) {
    this.title = title;
    return this;
  }

  /**
   * エラーのタイトル
   * @return title
  */
  @NotNull
  @Schema(name = "title", description = "エラーのタイトル", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ResourceNotFoundError detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * エラーの詳細
   * @return detail
  */
  @NotNull
  @Schema(name = "detail", description = "エラーの詳細", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceNotFoundError resourceNotFoundError = (ResourceNotFoundError) o;
    return Objects.equals(this.title, resourceNotFoundError.title) &&
        Objects.equals(this.detail, resourceNotFoundError.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceNotFoundError {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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

