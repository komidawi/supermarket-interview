package com.github.komidawi.interview.old;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class PriceStoreImpl implements PriceStore {

    private final ProductSupplier productSupplier;

    @Override
    public Optional<Integer> getPrice(String barcode) {
        Optional<Product> product = productSupplier.supplyProduct(barcode);
        if (product.isPresent()) {
            return Optional.of(product.get().getPrice());
        } else {
            return Optional.empty();
        }
    }
}
