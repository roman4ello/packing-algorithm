package com.boyar.packing.algorithm.model;

public class Product {
    private Dimensions dimensions;

    public Product(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "dimensions=" + dimensions +
                '}';
    }
}
