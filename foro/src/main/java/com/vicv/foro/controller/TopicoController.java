package com.vicv.foro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TopicoController {

    @GetMapping
    public String helloWorld(){
        return "Hola Mundo!!!";
    }
}
