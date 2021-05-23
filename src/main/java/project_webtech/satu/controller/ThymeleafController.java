package project_webtech.satu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project_webtech.satu.config.endpoints;
import project_webtech.satu.config.viewNames;

@Controller
public class ThymeleafController {

    @GetMapping(path= endpoints.INDEX)
    public ModelAndView showIndexPage(){
        return new ModelAndView(viewNames.INDEX);
    }
}
