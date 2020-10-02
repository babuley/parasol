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
 * Where an API may respond with an asynchronous &#39;Accepted&#39; (HTTP 202) response, it will return an AsyncResponse object. The eventual                 response will be returned by way of an async event, containing the corresponding correlation ID header returned below.                                  The location of the correlation ID will depend upon the eventing transport in use - though typically it will be included as a message header (rather than a payload).             
 */
@ApiModel(description = "Where an API may respond with an asynchronous 'Accepted' (HTTP 202) response, it will return an AsyncResponse object. The eventual                 response will be returned by way of an async event, containing the corresponding correlation ID header returned below.                                  The location of the correlation ID will depend upon the eventing transport in use - though typically it will be included as a message header (rather than a payload).             ")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-02T16:50:59.160267+01:00[Europe/London]")

public class AsyncResponse   {
  @JsonProperty("id")
  private String id;

  public AsyncResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Correlation Identifier
   * @return id
  */
  @ApiModelProperty(example = "8FE4E2F3-7351-4385-B0C6-1154A440F956", required = true, value = "Correlation Identifier")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsyncResponse asyncResponse = (AsyncResponse) o;
    return Objects.equals(this.id, asyncResponse.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AsyncResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

