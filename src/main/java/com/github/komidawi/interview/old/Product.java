package com.github.komidawi.interview.old;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Product {
    private final String id;

    @Getter
    private final int price;
}