package com.github.komidawi.interview.domain;

import com.github.komidawi.interview.api.ApiFacade;
import com.github.komidawi.interview.api.Barcode;
import com.github.komidawi.interview.api.Money;
import com.github.komidawi.interview.api.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainProcessorTest {

    private final ApiFacade mainProcessor = new MainProcessor(barcode -> new Product());

    @Test
    public void afterScanningItem_itsPriceIsAddedToTotalSum() {
        // given
        Barcode barcode = new Barcode("123");

        // when
        mainProcessor.scanItem(barcode);

        // then
        Money totalPrice = mainProcessor.getTotalPrice();
        assertEquals(new Money(10), totalPrice);
    }

}