package com.boyar.packing.algorithm.model;

public class Order {
    private Product product;
    private Integer itemsCount;

    public Order(Product product, Integer itemsNumber) {
        this.product = product;
        this.itemsCount = itemsNumber;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", itemsCount=" + itemsCount +
                '}';
    }
}
