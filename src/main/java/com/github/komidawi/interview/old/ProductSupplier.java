package com.github.komidawi.interview.old;

import java.util.Optional;

@FunctionalInterface
public interface ProductSupplier {
    Optional<Product> supplyProduct(String barcode);
}
