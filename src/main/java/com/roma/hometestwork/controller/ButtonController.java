package com.roma.hometestwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ButtonController {

    @GetMapping("/buttons")
    @ModelAttribute
    public void showButton() {
    }
}