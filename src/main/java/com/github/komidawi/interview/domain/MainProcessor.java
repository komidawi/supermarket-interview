package com.github.komidawi.interview.domain;

import com.github.komidawi.interview.api.ApiFacade;
import com.github.komidawi.interview.api.Barcode;
import com.github.komidawi.interview.api.Money;
import com.github.komidawi.interview.api.product.Product;
import com.github.komidawi.interview.api.product.ProductProviderApi;

import java.util.*;

public class MainProcessor implements ApiFacade {

    private final ProductProviderApi productProvider;

    private final List<Product> bill = new ArrayList<>();

    public MainProcessor(ProductProviderApi productProvider) {
        this.productProvider = productProvider;
    }

    @Override
    public void scanItem(Barcode barcode) {
        Product product = productProvider.findProduct(barcode);
        bill.add(product);
    }

    @Override
    public Money getTotalPrice() {
        Integer totalPrice = bill.stream()
                .map(product -> product.price().value())
                .reduce(0, Integer::sum);
        return new Money(totalPrice);
    }
}
