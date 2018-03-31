package com.miko.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FreeMarkerController {


    @GetMapping("/index")
    public String index(){
        System.out.println("INDEX");
        return "index";
    }

    @GetMapping(path = "/magic")
    public ModelAndView magic(@RequestParam(name = "word", required=false, defaultValue="MagicHappens") String word) {
        System.out.println("MAGIC");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("magic");
        mav.addObject("word", word);
        return mav;
    }

}
