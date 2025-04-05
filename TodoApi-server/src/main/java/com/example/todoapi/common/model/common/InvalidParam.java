package com.example.todoapi.common.model.common;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

/**
 * 不正なリクエストについての詳細
 */

@Schema(name = "InvalidParam", description = "不正なリクエストについての詳細")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T08:54:47.507584900+09:00[Asia/Tokyo]")
public class InvalidParam {

  @JsonProperty("name")
  private String name;

  @JsonProperty("reason")
  private String reason;

  public InvalidParam name(String name) {
    this.name = name;
    return this;
  }

  /**
   * エラーが発生したフィールド名
   * @return name
  */
  @NotNull
  @Schema(name = "name", description = "エラーが発生したフィールド名", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InvalidParam reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * エラーの理由
   * @return reason
  */
  @NotNull
  @Schema(name = "reason", description = "エラーの理由", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvalidParam invalidParam = (InvalidParam) o;
    return Objects.equals(this.name, invalidParam.name) &&
        Objects.equals(this.reason, invalidParam.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvalidParam {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

