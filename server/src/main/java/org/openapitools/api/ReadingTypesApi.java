/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ReadingType;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-02T16:50:59.160267+01:00[Europe/London]")

@Validated
@Api(value = "readingTypes", description = "the readingTypes API")
public interface ReadingTypesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /readingTypes
     * Return a list of reading types that may queried or invoked
     *
     * @return Returning a list of reading types (status code 200)
     */
    @ApiOperation(value = "", nickname = "getReadingTypes", notes = "Return a list of reading types that may queried or invoked", response = ReadingType.class, responseContainer = "List", authorizations = {
        @Authorization(value = "jwt")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returning a list of reading types", response = ReadingType.class, responseContainer = "List") })
    @RequestMapping(value = "/readingTypes",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<ReadingType>> getReadingTypes() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
