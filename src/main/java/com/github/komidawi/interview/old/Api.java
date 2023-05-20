package com.github.komidawi.interview.old;

public interface Api {

    void scanProduct(String barcode) throws InvalidProductException;
    int getCurrentValue();
}
