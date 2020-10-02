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
 * CreateRecordResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-02T17:20:43.453855+01:00[Europe/London]")

public class CreateRecordResponse   {
  @JsonProperty("recordId")
  private String recordId;

  public CreateRecordResponse recordId(String recordId) {
    this.recordId = recordId;
    return this;
  }

  /**
   * The ID of the record created
   * @return recordId
  */
  @ApiModelProperty(example = "FF78B5C3-44B3-4DC6-8A2A-7D85153869FC", required = true, value = "The ID of the record created")
  @NotNull


  public String getRecordId() {
    return recordId;
  }

  public void setRecordId(String recordId) {
    this.recordId = recordId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateRecordResponse createRecordResponse = (CreateRecordResponse) o;
    return Objects.equals(this.recordId, createRecordResponse.recordId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recordId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateRecordResponse {\n");
    
    sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
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

