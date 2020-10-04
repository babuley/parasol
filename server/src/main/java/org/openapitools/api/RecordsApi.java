/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ErrorResponse;
import org.openapitools.model.Record;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-03T10:33:08.802504+01:00[Europe/London]")

@Validated
@Api(value = "records", description = "the records API")
public interface RecordsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /records
     * Register a reading record for a given customer
     *
     * @param customerId The ID of the customer (required)
     * @param recordDAO Details of the record for the customer (text, when, schedule, severity, etc) (required)
     * @return One or more errors have occurred when attempting to process the provided data (status code 400)
     */
    @ApiOperation(value = "", nickname = "createRecord", notes = "Register a reading record for a given customer", authorizations = {
        @Authorization(value = "jwt")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "One or more errors have occurred when attempting to process the provided data", response = ErrorResponse.class) })
    @RequestMapping(value = "/records",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> createRecord(@ApiParam(value = "The ID of the customer",required=true) @PathVariable("customerId") String customerId,@ApiParam(value = "Details of the record for the customer (text, when, schedule, severity, etc)" ,required=true )  @Valid @RequestBody Record recordDAO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /records
     * Provide basic records 
     *
     * @param customerCode The code for the customer for which the records should be returned (required)
     * @param format Format for the output. TBD, but may be used to control the scope of information returned. (optional)
     * @return The record info (status code 200)
     *         or One or more errors have occurred when attempting to process the provided data (status code 400)
     *         or Forbidden - you do not have the necessary permissions to undertake this action (status code 403)
     */
    @ApiOperation(value = "", nickname = "getRecords", notes = "Provide basic records ", response = Record.class, responseContainer = "List", authorizations = {
        @Authorization(value = "jwt")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The record info", response = Record.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "One or more errors have occurred when attempting to process the provided data", response = ErrorResponse.class),
        @ApiResponse(code = 403, message = "Forbidden - you do not have the necessary permissions to undertake this action", response = ErrorResponse.class) })
    @RequestMapping(value = "/records",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Record>> getRecords(@NotNull @ApiParam(value = "The code for the customer for which the records should be returned", required = true) @Valid @RequestParam(value = "customerCode", required = false) String customerCode, @ApiParam(value = "Format for the output. TBD, but may be used to control the scope of information returned.") @Valid @RequestParam(value = "format", required = false) String format) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"accountId\" : \"accountId\", \"customerId\" : \"customerId\", \"id\" : \"id\", \"when\" : \"2000-01-23\", \"value\" : \"value\", \"readingType\" : \"readingType\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
