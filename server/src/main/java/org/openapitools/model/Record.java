package org.openapitools.model;

import java.time.LocalDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Record
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-03T10:33:08.802504+01:00[Europe/London]")

public class Record {
  @JsonProperty("id")
  private String id;

  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("accountId")
  private String accountId;

  @JsonProperty("when")
  @org.springframework.format.annotation.DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime when;

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

  public Record accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public Record when(LocalDateTime when) {
    this.when = when;
    return this;
  }

  /**
   * Get when
   * @return when
  */
  @ApiModelProperty(required = true, value = "")

  public LocalDateTime getWhen() {
    return when;
  }

  public void setWhen(LocalDateTime when) {
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
    Record recordDAO = (Record) o;
    return Objects.equals(this.id, recordDAO.id) &&
        Objects.equals(this.customerId, recordDAO.customerId) &&
        Objects.equals(this.accountId, recordDAO.accountId) &&
        Objects.equals(this.when, recordDAO.when) &&
        Objects.equals(this.value, recordDAO.value) &&
        Objects.equals(this.readingType, recordDAO.readingType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customerId, accountId, when, value, readingType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Record {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
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

