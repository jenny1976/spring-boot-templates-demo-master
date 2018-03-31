package com.miko.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PebbleController {

    @GetMapping(value = "/")
    public ModelAndView something(){
        System.out.println("Pebble");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("pebble");
        mav.addObject("pebble", "The Pebble");
        mav.addObject("header", "header");
        mav.addObject("footer", "footer");
        return mav;
    }

    @GetMapping(value = "/home")
    public ModelAndView goHome(){
        ModelAndView mav = new ModelAndView();
        System.out.println("Pebble home");
        mav.setViewName("home");
        mav.addObject("name", "The Pebble");
        mav.addObject("header", "header");
        mav.addObject("footer", "footer");
        return mav;
    }
}
