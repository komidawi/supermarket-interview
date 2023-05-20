package com.github.komidawi.interview.old;

import java.util.Optional;

public class CheckoutComponent implements Api{

    private final PriceStore priceStore;

    private int currentPrice = 0;

    public CheckoutComponent(PriceStore priceStore) {
        this.priceStore = priceStore;
    }

    @Override
    public void scanProduct(String barcode) throws InvalidProductException {
        Optional<Integer> price = priceStore.getPrice(barcode);
        if (price.isPresent()) {
            currentPrice += price.get();
        } else {
            throw new InvalidProductException();
        }
    }

    @Override
    public int getCurrentValue() {
        return currentPrice;
    }
}


