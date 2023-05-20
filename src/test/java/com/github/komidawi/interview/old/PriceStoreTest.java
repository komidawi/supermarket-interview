package com.github.komidawi.interview.old;

import com.github.komidawi.interview.old.PriceStore;
import com.github.komidawi.interview.old.PriceStoreImpl;
import com.github.komidawi.interview.old.Product;
import com.github.komidawi.interview.old.ProductSupplier;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceStoreTest {

    private static final int HARDCODED_PRICE = 10;
    private PriceStore priceStore = new PriceStoreImpl(
            barcode -> java.util.Optional.of(new Product(barcode, HARDCODED_PRICE)));

    @Test
    public void whenProductIsFound_returnThePrice() {
        // given
        String barcode = "123";

        // when
        Optional<Integer> price = priceStore.getPrice(barcode);

        // then
        assertEquals(HARDCODED_PRICE, price.get());
    }

    @Test
    public void whenProductIsNotFound_ReturnEmptyPrice() {
        // given
        ProductSupplier productSupplier = mock(ProductSupplier.class);
        when(productSupplier.supplyProduct(any())).thenReturn(Optional.empty());
        PriceStore priceStore_ = new PriceStoreImpl(productSupplier);

        // when
        Optional<Integer> price = priceStore_.getPrice("123");

        // then
        assertTrue(price.isEmpty());
    }

}