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
 * Represents a span of time, implicitly covering a maximum of 24hrs
 */
@ApiModel(description = "Represents a span of time, implicitly covering a maximum of 24hrs")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-03T10:33:08.802504+01:00[Europe/London]")

public class TimeSpan   {
  @JsonProperty("from")
  private String from;

  @JsonProperty("to")
  private String to;

  public TimeSpan from(String from) {
    this.from = from;
    return this;
  }

  /**
   * Time from, 24hr format
   * @return from
  */
  @ApiModelProperty(example = "01:00", required = true, value = "Time from, 24hr format")
  @NotNull

@Pattern(regexp="^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") 
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public TimeSpan to(String to) {
    this.to = to;
    return this;
  }

  /**
   * Time from, 24hr format
   * @return to
  */
  @ApiModelProperty(example = "08:30", value = "Time from, 24hr format")

@Pattern(regexp="^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") 
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeSpan timeSpan = (TimeSpan) o;
    return Objects.equals(this.from, timeSpan.from) &&
        Objects.equals(this.to, timeSpan.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeSpan {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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

