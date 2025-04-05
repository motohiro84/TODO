package com.example.todoapi.common.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * ページング情報
 */

@Schema(name = "PageDTO", description = "ページング情報")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T08:54:47.507584900+09:00[Asia/Tokyo]")
public class PageDto {

  @JsonProperty("limit")
  private Integer limit;

  @JsonProperty("offset")
  private Long offset;

  @JsonProperty("size")
  private Integer size;

  public PageDto limit(Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * リクエストされた limit
   * @return limit
  */
  @NotNull
  @Schema(name = "limit", description = "リクエストされた limit", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public PageDto offset(Long offset) {
    this.offset = offset;
    return this;
  }

  /**
   * リクエストされた offset
   * @return offset
  */
  @NotNull
  @Schema(name = "offset", description = "リクエストされた offset", requiredMode = Schema.RequiredMode.REQUIRED)
  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public PageDto size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * 取得できた件数
   * @return size
  */
  @NotNull
  @Schema(name = "size", description = "取得できた件数", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageDto pageDTO = (PageDto) o;
    return Objects.equals(this.limit, pageDTO.limit) &&
        Objects.equals(this.offset, pageDTO.offset) &&
        Objects.equals(this.size, pageDTO.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(limit, offset, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageDTO {\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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

