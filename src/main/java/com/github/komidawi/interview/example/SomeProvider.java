package com.github.komidawi.interview.example;

import org.springframework.stereotype.Service;

@Service
public class SomeProvider implements Provider {
    @Override
    public String provide() {
        return "Provided Value";
    }
}
