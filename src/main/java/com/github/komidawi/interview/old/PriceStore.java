package com.github.komidawi.interview.old;

import java.util.Optional;

public interface PriceStore {
    Optional<Integer> getPrice(String barcode);
}
