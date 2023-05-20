package com.github.komidawi.interview.api.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductNotFoundException extends Exception {
    private final String message;
}
