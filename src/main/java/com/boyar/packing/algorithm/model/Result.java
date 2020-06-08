package com.boyar.packing.algorithm.model;

import java.util.List;

public class Result {
    private Order order;
    private Integer price;
    private Case caseDetails;
    private Integer caseCount;
    private Integer freeSpace;

    public Result(Order order, List<Case> cases) {
        this.order = order;
        this.price = getPrice(cases);
        this.caseDetails = cases.get(0);
        this.caseCount = cases.size();
        this.freeSpace = getFreeSpace(order, cases);
    }

    private int getPrice(List<Case> cases) {
        return cases.size() == 0 ? 0 : cases.get(0).getPrice() * cases.size();
    }

    private int getFreeSpace(Order order, List<Case> cases) {
        return cases.size() == 0 ?
                0 : cases.size() * cases.get(0).getDimensions().getVolume() - order.getItemsCount() * order.getProduct().getDimensions().getVolume();
    }

    @Override
    public String toString() {
        return "Result{\n" +
                "order=" + order +
                ",\n price=" + price +
                ",\n caseDetails=" + caseDetails +
                ",\n caseCount=" + caseCount +
                ",\n freeSpace=" + freeSpace +
                "\n}\n===========";
    }
}
