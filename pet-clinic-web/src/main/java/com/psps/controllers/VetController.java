package com.psps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vets")
@Controller
public class VetController {
    @RequestMapping({"","/","/index","/index.html"})
    public String listAllVets(){
        return "vets/index";
    }
}
