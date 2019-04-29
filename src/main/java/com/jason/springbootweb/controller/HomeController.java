package com.jason.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
    @RequestMapping(value = "/Home/index", method = RequestMethod.GET)
    public Object index() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object Home(){
        return "forward:/Home/index";
    }
}

