package org.openapitools.api;

import io.swagger.annotations.*;
import org.openapitools.model.ErrorResponse;
import org.openapitools.model.Record;
import org.openapitools.services.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-03T10:33:08.802504+01:00[Europe/London]")

@Controller
@RequestMapping("${openapi.parasol.base-path:/api/v1}")
public class RecordsApiController implements RecordsApi {

    private final NativeWebRequest request;

    @Autowired
    IRecordService recordService;

    @org.springframework.beans.factory.annotation.Autowired
    public RecordsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
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
    public ResponseEntity<List<Record>> getRecords(@RequestParam(value = "customerCode", required = false) String customerCode, @ApiParam(value = "Format for the output. TBD, but may be used to control the scope of information returned.") @Valid @RequestParam(value = "format", required = false) String format) {


        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"accountId\" : \"accountId\", \"customerId\" : \"customerId\", \"id\" : \"id\", \"when\" : \"2000-01-23\", \"value\" : \"value\", \"readingType\" : \"readingType\" }";
                   // ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });

        List<Record> records = recordService.getRecords();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<List<Record>>(records, responseHeaders, HttpStatus.OK);

    }
}
