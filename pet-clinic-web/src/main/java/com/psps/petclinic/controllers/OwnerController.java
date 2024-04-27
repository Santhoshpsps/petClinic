package com.psps.petclinic.controllers;

import com.psps.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String listAllOwners(Model model){
        model.addAttribute("owners",ownerService.findAll().stream().toList());
        return "owners/index";
    }

    @RequestMapping("find")
    public String notIMpl(){
        return "notImplemented";
    }
}
