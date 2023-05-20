package com.github.komidawi.interview.api.product;

import com.github.komidawi.interview.api.Barcode;
import com.github.komidawi.interview.api.Money;

public record Product(Barcode barcode, Money price) {
}
