package com.github.komidawi.interview.example;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/example")
public class Api {

    private final DomainLogic domainLogic;

    @GetMapping
    public String helloWorld() {
        return domainLogic.generateNumbers().toString();
    }
}
