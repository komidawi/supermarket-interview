package com.github.komidawi.interview.api.product;

import com.github.komidawi.interview.api.Barcode;

@FunctionalInterface
public interface ProductProviderApi {
    Product findProduct(Barcode barcode);
}
