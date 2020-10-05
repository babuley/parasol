package org.openapitools.configuration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParasolController {

    @RequestMapping("/parasol/*")
    public String index() {
        return "redirect:monitor/index.html";
    }
}
