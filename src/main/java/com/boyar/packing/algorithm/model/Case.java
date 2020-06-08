package com.boyar.packing.algorithm.model;

public class Case implements Comparable<Case>{
    private Dimensions dimensions;
    private Integer price;

    public Case(Dimensions dimensions, Integer price) {
        this.dimensions = dimensions;
        this.price = price;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Case{" +
                "dimensions=" + dimensions +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Case o) {
        return this.price.compareTo(o.price);
    }
}
