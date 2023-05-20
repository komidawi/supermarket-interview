package com.github.komidawi.interview.domain;

import com.github.komidawi.interview.api.ApiFacade;
import com.github.komidawi.interview.api.Barcode;
import com.github.komidawi.interview.api.Money;
import com.github.komidawi.interview.api.product.Product;
import com.github.komidawi.interview.api.product.ProductProviderApi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainProcessorTest {
    private final ProductProviderApi productProviderApi = barcode ->
            new Product(barcode, new Money(Integer.parseInt(barcode.value())));
    private final ApiFacade mainProcessor = new MainProcessor(productProviderApi);

    @Test
    public void afterScanningItem_itsPriceIsAddedToTotalSum() {
        // given
        int itemPrice = 123;
        Barcode barcode = new Barcode(String.valueOf(itemPrice));

        // when
        mainProcessor.scanItem(barcode);

        // then
        Money totalPrice = mainProcessor.getTotalPrice();
        assertEquals(new Money(itemPrice), totalPrice);
    }

    @Test
    public void afterScanningTwoItems_theirTotalSumIsReturned() {
        // given
        int firstItemPrice = 123;
        Barcode firstItemBarcode = new Barcode(String.valueOf(firstItemPrice));

        // and
        int secondItemPrice = 456;
        Barcode secondItemBarcode = new Barcode(String.valueOf(secondItemPrice));

        // when
        mainProcessor.scanItem(firstItemBarcode);
        mainProcessor.scanItem(secondItemBarcode);

        // then
        Money totalPrice = mainProcessor.getTotalPrice();
        assertEquals(new Money(firstItemPrice + secondItemPrice), totalPrice);
    }
}

