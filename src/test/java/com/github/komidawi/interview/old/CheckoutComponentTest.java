package com.github.komidawi.interview.old;

import com.github.komidawi.interview.old.Api;
import com.github.komidawi.interview.old.CheckoutComponent;
import com.github.komidawi.interview.old.InvalidProductException;
import com.github.komidawi.interview.old.PriceStore;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CheckoutComponentTest {

    @Test
    public void afterProductIsScanned_returnPrice() throws InvalidProductException {
        // given
        int productPrice = 10;
        PriceStore priceStore = mock(PriceStore.class);
        when(priceStore.getPrice(any())).thenReturn(Optional.of(productPrice));
        Api api = new CheckoutComponent(priceStore);

        // when
        api.scanProduct("123");

        // and
        int currentValue = api.getCurrentValue();

        // then
        assertEquals(productPrice, currentValue);
    }

    // TODO: many items test

    @Test
    public void scanningNonExistingProduct_throwsException() {
        // given
        PriceStore priceStore = mock(PriceStore.class);
        when(priceStore.getPrice(any())).thenReturn(Optional.empty());
        Api api = new CheckoutComponent(priceStore);

        // when
        try {
            api.scanProduct("123");
        } catch (InvalidProductException e) {
            assertNotNull(e);
            return;
        }

        fail();
    }

}