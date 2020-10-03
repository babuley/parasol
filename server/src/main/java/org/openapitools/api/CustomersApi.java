/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Customer;
import org.openapitools.model.ErrorResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-03T10:33:08.802504+01:00[Europe/London]")

@Validated
@Api(value = "customers", description = "the customers API")
public interface CustomersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /customers
     * Register a customer record
     *
     * @param customer Details of the customer  (required)
     * @return One or more errors have occurred when attempting to process the provided data (status code 400)
     */
    @ApiOperation(value = "", nickname = "createCustomer", notes = "Register a customer record", authorizations = {
        @Authorization(value = "jwt")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "One or more errors have occurred when attempting to process the provided data", response = ErrorResponse.class) })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> createCustomer(@ApiParam(value = "Details of the customer " ,required=true )  @Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /customers
     * Provide basic records 
     *
     * @param customerCode The code for the customer for which the records should be returned (required)
     * @param format Format for the output. TBD, but may be used to control the scope of information returned. (optional)
     * @return The customer info (status code 200)
     *         or One or more errors have occurred when attempting to process the provided data (status code 400)
     *         or Forbidden - you do not have the necessary permissions to undertake this action (status code 403)
     */
    @ApiOperation(value = "", nickname = "getCustomers", notes = "Provide basic records ", response = Customer.class, responseContainer = "List", authorizations = {
        @Authorization(value = "jwt")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The customer info", response = Customer.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "One or more errors have occurred when attempting to process the provided data", response = ErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden - you do not have the necessary permissions to undertake this action", response = ErrorResponse.class) })
    @RequestMapping(value = "/customers",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Customer>> getCustomers(@NotNull @ApiParam(value = "The code for the customer for which the records should be returned", required = true) @Valid @RequestParam(value = "customerCode", required = true) String customerCode,@ApiParam(value = "Format for the output. TBD, but may be used to control the scope of information returned.") @Valid @RequestParam(value = "format", required = false) String format) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"contact\" : { \"emailAddress\" : \"emailAddress\", \"phone\" : \"phone\" }, \"customer\" : { \"surname\" : \"Smith\", \"customerId\" : \"customerId\", \"dateOfBirth\" : \"2000-01-23\", \"forenames\" : \"Fred\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
