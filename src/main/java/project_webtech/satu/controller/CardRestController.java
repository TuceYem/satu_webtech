package project_webtech.satu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import project_webtech.satu.config.endpoints;
import project_webtech.satu.config.viewNames;

@Controller
public class CardRestController {

    @GetMapping(path= endpoints.INDEX)
    public ModelAndView showIndexPage(){
        return new ModelAndView(viewNames.INDEX);
    }

    @GetMapping(path= endpoints.SLASH_INDEX)
    public ModelAndView showIndexWithSlashPage(){
        return new ModelAndView(viewNames.INDEX);
    }

    @GetMapping(path =endpoints.STUDY)
    public ModelAndView showStudyPage(){ return new ModelAndView(viewNames.STUDY);}

    @GetMapping(path =endpoints.DECKS)
    public ModelAndView showDecksPage(){ return new ModelAndView(viewNames.DECKS);}
}
