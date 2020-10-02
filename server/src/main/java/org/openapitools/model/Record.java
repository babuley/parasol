package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Record
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-02T17:20:43.453855+01:00[Europe/London]")

public class Record   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("when")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate when;

  @JsonProperty("value")
  private String value;

  @JsonProperty("readingType")
  private String readingType;

  public Record id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Record customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Record when(LocalDate when) {
    this.when = when;
    return this;
  }

  /**
   * Get when
   * @return when
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public LocalDate getWhen() {
    return when;
  }

  public void setWhen(LocalDate when) {
    this.when = when;
  }

  public Record value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Text of the message to be registered
   * @return value
  */
  @ApiModelProperty(required = true, value = "Text of the message to be registered")
  @NotNull


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Record readingType(String readingType) {
    this.readingType = readingType;
    return this;
  }

  /**
   * Optional messageType for this message
   * @return readingType
  */
  @ApiModelProperty(value = "Optional messageType for this message")


  public String getReadingType() {
    return readingType;
  }

  public void setReadingType(String readingType) {
    this.readingType = readingType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Record record = (Record) o;
    return Objects.equals(this.id, record.id) &&
        Objects.equals(this.customerId, record.customerId) &&
        Objects.equals(this.when, record.when) &&
        Objects.equals(this.value, record.value) &&
        Objects.equals(this.readingType, record.readingType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customerId, when, value, readingType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Record {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    when: ").append(toIndentedString(when)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    readingType: ").append(toIndentedString(readingType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

