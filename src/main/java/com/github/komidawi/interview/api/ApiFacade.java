package com.github.komidawi.interview.api;

public interface ApiFacade {
    void scanItem(Barcode barcode);

    Money getTotalPrice();
}
