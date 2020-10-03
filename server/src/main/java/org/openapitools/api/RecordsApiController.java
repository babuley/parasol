package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-03T10:33:08.802504+01:00[Europe/London]")

@Controller
@RequestMapping("${openapi.parasol.base-path:/api/v1}")
public class RecordsApiController implements RecordsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RecordsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
