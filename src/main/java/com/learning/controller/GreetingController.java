package com.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, ModelMap modelMap){

        // add attribute to load modelMap
        modelMap.addAttribute("greet",
                "Hello " + name);

        // return the name of the file to be loaded "hello_world.jsp"
        return "greeting";
    }
}
