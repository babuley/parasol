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
 * CustomerCustomer
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-02T16:50:59.160267+01:00[Europe/London]")

public class CustomerCustomer   {
  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("forenames")
  private String forenames;

  @JsonProperty("dateOfBirth")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate dateOfBirth;

  public CustomerCustomer customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @ApiModelProperty(value = "")


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public CustomerCustomer surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Surname for the person
   * @return surname
  */
  @ApiModelProperty(example = "Smith", value = "Surname for the person")


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public CustomerCustomer forenames(String forenames) {
    this.forenames = forenames;
    return this;
  }

  /**
   * List of forenames for the person
   * @return forenames
  */
  @ApiModelProperty(example = "Fred", value = "List of forenames for the person")


  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public CustomerCustomer dateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   * @return dateOfBirth
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerCustomer customerCustomer = (CustomerCustomer) o;
    return Objects.equals(this.customerId, customerCustomer.customerId) &&
        Objects.equals(this.surname, customerCustomer.surname) &&
        Objects.equals(this.forenames, customerCustomer.forenames) &&
        Objects.equals(this.dateOfBirth, customerCustomer.dateOfBirth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, surname, forenames, dateOfBirth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerCustomer {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    forenames: ").append(toIndentedString(forenames)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
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

