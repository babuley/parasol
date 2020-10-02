package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Record
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-02T16:50:59.160267+01:00[Europe/London]")

public class Record   {
  @JsonProperty("messageId")
  private String messageId;

  @JsonProperty("patientId")
  private String patientId;

  @JsonProperty("messageText")
  private String messageText;

  @JsonProperty("messageType")
  private String messageType;

  public Record messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  /**
   * Get messageId
   * @return messageId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public Record patientId(String patientId) {
    this.patientId = patientId;
    return this;
  }

  /**
   * Get patientId
   * @return patientId
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public Record messageText(String messageText) {
    this.messageText = messageText;
    return this;
  }

  /**
   * Text of the message to be registered
   * @return messageText
  */
  @ApiModelProperty(required = true, value = "Text of the message to be registered")
  @NotNull


  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public Record messageType(String messageType) {
    this.messageType = messageType;
    return this;
  }

  /**
   * Optional messageType for this message
   * @return messageType
  */
  @ApiModelProperty(value = "Optional messageType for this message")


  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
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
    return Objects.equals(this.messageId, record.messageId) &&
        Objects.equals(this.patientId, record.patientId) &&
        Objects.equals(this.messageText, record.messageText) &&
        Objects.equals(this.messageType, record.messageType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageId, patientId, messageText, messageType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Record {\n");
    
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    patientId: ").append(toIndentedString(patientId)).append("\n");
    sb.append("    messageText: ").append(toIndentedString(messageText)).append("\n");
    sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
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

