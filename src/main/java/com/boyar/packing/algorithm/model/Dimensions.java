package com.boyar.packing.algorithm.model;

public class Dimensions {
    private Integer length;
    private Integer width;
    private Integer height;

    public Dimensions(Integer length, Integer width, Integer height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "Dimensions{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
