package com.boyar.packing.algorithm;

import com.boyar.packing.algorithm.model.Case;
import com.boyar.packing.algorithm.model.Dimensions;
import com.boyar.packing.algorithm.model.Order;
import com.boyar.packing.algorithm.model.Product;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DataLoader {
    private final TreeSet<Case> cases = new TreeSet<>();
    private final Set<Order> orders = new HashSet<>();

    public DataLoader() {
        initialization();
    }

    public TreeSet<Case> getCases() {
        return cases;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    private void initialization() {
        addCases();
        addOrders();
    }

    private void addOrders() {
        orders.add(new Order(new Product(new Dimensions(2, 2, 2)), 10));
        orders.add(new Order(new Product(new Dimensions(4, 4, 3)), 2));
        orders.add(new Order(new Product(new Dimensions(1, 1, 3)), 2));
    }

    private void addCases() {
        cases.add(new Case(new Dimensions(10, 10, 4), 20));
        cases.add(new Case(new Dimensions(5, 5, 3), 5));
        cases.add(new Case(new Dimensions(2, 2, 2), 1));
    }
}
