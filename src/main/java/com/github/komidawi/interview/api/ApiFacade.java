package com.github.komidawi.interview.api;

import com.github.komidawi.interview.api.product.ProductNotFoundException;

public interface ApiFacade {
    void scanItem(Barcode barcode) throws ProductNotFoundException;

    Money getTotalPrice();
}
