package com.epam.engx.cleancode.functions.task2;

import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Product;

import java.util.List;

public class Order {

    private List<Product> products;

    public Double getPriceOfAvailableProducts() {
        return products.stream()
                .filter(Product::isAvailable)
                .mapToDouble(Product::getProductPrice)
                .sum();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
