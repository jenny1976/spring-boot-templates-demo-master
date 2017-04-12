/*
 * Copyright (C) 2016. Miroslav Kopecky
 * This PebbleHelloController.java is part of spring-boot-freemaker-demo.
 *
 *     spring-boot-freemaker-demo is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     spring-boot-freemaker-demo is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with spring-boot-freemaker-demo .  If not, see <http://www.gnu.org/licenses/>.
 */

package com.miko.springboot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Miro Kopecky (@miragemiko)
 * @since 08.11.2016
 */

@RestController
public class PebbleHelloController {

    @GetMapping(value = "/")
    public String something(Model model){
        System.out.println("Pebble");
        model.addAttribute("pebble", "The Pebble");
        model.addAttribute("header", "h");
        model.addAttribute("footer", "f");
        return "pebble";
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
