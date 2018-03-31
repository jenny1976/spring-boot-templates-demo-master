package com.miko.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ThymeleafController {


    @GetMapping("/thyme")
    public ModelAndView something() {
        ModelAndView mav = new ModelAndView();
        System.out.println("Thymeleaf");
        mav.setViewName("thyme.htm");
        mav.addObject("thyme", "The Thymeleaf");
        return mav;
    }

}
