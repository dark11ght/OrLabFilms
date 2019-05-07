package com.dark1ight.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIControllers {

    @RequestMapping(value = {"/", "index"})
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = {"sign_page"})
    public String getSignPage(){
        return "sign_page";
    }

}
