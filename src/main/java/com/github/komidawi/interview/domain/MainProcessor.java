package com.github.komidawi.interview.domain;

import com.github.komidawi.interview.api.ApiFacade;
import com.github.komidawi.interview.api.Barcode;
import com.github.komidawi.interview.api.Money;
import com.github.komidawi.interview.api.product.ProductProviderApi;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MainProcessor implements ApiFacade {

    private final ProductProviderApi productProvider;

    @Override
    public void scanItem(Barcode barcode) {
        productProvider.findProduct(barcode);
    }

    @Override
    public Money getTotalPrice() {
        return null;
    }
}
