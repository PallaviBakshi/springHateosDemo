package com.example.springhateosdemo.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.example.springhateosdemo.model.HateosModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HateosController {

    private static final String TEMPLATE = "Spring_Hateos_Demo, %s!";

    @RequestMapping("/springhateosdemo")
    public HttpEntity<HateosModel> hateosModel(
            @RequestParam(value = "descp", required = false, defaultValue = "Used for adding the link.") String name) {

        HateosModel greeting = new HateosModel(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(HateosController.class).hateosModel(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
