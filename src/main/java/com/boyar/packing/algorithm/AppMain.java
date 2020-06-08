package com.boyar.packing.algorithm;

import com.boyar.packing.algorithm.model.Result;

import java.util.List;

public class AppMain {
    /*
Write an algorithm to pack an order into the given cases. The order consists of a few orderliness, each of
them consists of a product and number of items. Products and cases have dimensions: x, y, and z.
Assume that they have a shape of a rectangle (boxes).
As a result please, provide the chosen cases, their number, and the total price of packing. The optimality
of a solution is determined by available empty space in boxes and the total price of the shipment.
 */

    public static void main(String[] args) {
        List<Result> optimalCasesForOrders = new Processor(new DataLoader()).findOptimalCasesForOrders();
        optimalCasesForOrders.forEach(result -> System.out.println(result));
    }

}
