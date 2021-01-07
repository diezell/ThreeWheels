package com.shop.wheels.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping("/category")
    public String showCategory() {
        return "";
    }

}