package com.boyar.packing.algorithm;

import com.boyar.packing.algorithm.model.Result;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        List<Result> optimalCasesForOrders = new Processor(new DataLoader()).findOptimalCasesForOrders();
        optimalCasesForOrders.forEach(result -> System.out.println(result));
    }
}
