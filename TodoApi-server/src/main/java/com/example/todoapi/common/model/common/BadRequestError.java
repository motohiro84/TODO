package com.example.todoapi.common.model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * リクエストが不正
 */

@Schema(name = "BadRequestError", description = "リクエストが不正")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T08:54:47.507584900+09:00[Asia/Tokyo]")
public class BadRequestError {

  @JsonProperty("title")
  private String title = "Bad Request";

  @JsonProperty("detail")
  private String detail = "リクエストが不正です。正しいリクエストでリトライしてください";

  @JsonProperty("invalid-params")
  @Valid
  private List<InvalidParam> invalidParams = new ArrayList<>();

  public BadRequestError title(String title) {
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

  public BadRequestError detail(String detail) {
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

  public BadRequestError invalidParams(List<InvalidParam> invalidParams) {
    this.invalidParams = invalidParams;
    return this;
  }

  public BadRequestError addInvalidParamsItem(InvalidParam invalidParamsItem) {
    this.invalidParams.add(invalidParamsItem);
    return this;
  }

  /**
   * Get invalidParams
   * @return invalidParams
  */
  @NotNull @Valid
  @Schema(name = "invalid-params", requiredMode = Schema.RequiredMode.REQUIRED)
  public List<InvalidParam> getInvalidParams() {
    return invalidParams;
  }

  public void setInvalidParams(List<InvalidParam> invalidParams) {
    this.invalidParams = invalidParams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequestError badRequestError = (BadRequestError) o;
    return Objects.equals(this.title, badRequestError.title) &&
        Objects.equals(this.detail, badRequestError.detail) &&
        Objects.equals(this.invalidParams, badRequestError.invalidParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, detail, invalidParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequestError {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    invalidParams: ").append(toIndentedString(invalidParams)).append("\n");
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

