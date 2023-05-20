package com.github.komidawi.interview.domain;

import com.github.komidawi.interview.api.ApiFacade;
import com.github.komidawi.interview.api.Barcode;
import com.github.komidawi.interview.api.Money;
import com.github.komidawi.interview.api.product.Product;
import com.github.komidawi.interview.api.product.ProductProviderApi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainProcessorTest {

    private static final Money EXAMPLE_PRICE = new Money(10);
    private final ProductProviderApi productProviderApi = barcode -> new Product(barcode, EXAMPLE_PRICE);
    private final ApiFacade mainProcessor = new MainProcessor(productProviderApi);

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
