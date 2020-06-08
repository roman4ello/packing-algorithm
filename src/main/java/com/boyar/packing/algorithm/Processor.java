package com.boyar.packing.algorithm;

import com.boyar.packing.algorithm.model.Case;
import com.boyar.packing.algorithm.model.Order;
import com.boyar.packing.algorithm.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Processor {
    private final DataLoader dataLoader;

    public Processor(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    public Map<Order, List<Case>> findOptimalCasesForOrders(final Set<Order> orders, final Set<Case> cases) {
        return orders
                .stream()
                .collect(Collectors.toMap(
                        order -> order,
                        order -> findOptimalCaseForOrder(order, cases),
                        (a, b) -> b));
    }

    private List<Case> findOptimalCaseForOrder(Order order, Set<Case> cases) {
        final TreeSet<Case> possibleCasesForProduct = getPossibleCasesForProduct(order, cases);
        return findCheapestCaseMap(possibleCasesForProduct, order);
    }

    private List<Case> findCheapestCaseMap(TreeSet<Case> acceptableSetCasesForProduct, Order order) {
        final int fullOrderVolume = order.getItemsCount() * order.getProduct().getDimensions().getVolume();
        return calculateCasesNumberForOrder(acceptableSetCasesForProduct, fullOrderVolume);
    }

    private List<Case> calculateCasesNumberForOrder(TreeSet<Case> possibleCasesForProduct, int fullOrderVolume) {
        final List<Case> cases = new ArrayList<>();
        for (Case aCase : possibleCasesForProduct) {
            final Integer currentCaseVolume = aCase.getDimensions().getVolume();
            if (fullOrderVolume <= currentCaseVolume) {
                cases.add(aCase);
                break;
            } else {
                cases.add(aCase);
                while (cases.size() * cases.get(0).getDimensions().getVolume() < fullOrderVolume) {
                    cases.add(aCase);
                }
                break;
            }

        }
        return cases;
    }

    private TreeSet<Case> getPossibleCasesForProduct(Order order, Set<Case> cases) {
        return cases
                .stream()
                .filter(aCase -> isCaseVolumeFitsToProduct(order, aCase) && isCaseSizesFitToProduct(order, aCase))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private boolean isCaseVolumeFitsToProduct(Order order, Case aCase) {
        return aCase.getDimensions().getVolume().compareTo(order.getProduct().getDimensions().getVolume()) >= 0;
    }

    private boolean isCaseSizesFitToProduct(Order order, Case aCase) {
        return aCase.getDimensions().getLength().compareTo(order.getProduct().getDimensions().getLength()) >= 0
                && aCase.getDimensions().getHeight().compareTo(order.getProduct().getDimensions().getHeight()) >= 0
                && aCase.getDimensions().getWidth().compareTo(order.getProduct().getDimensions().getWidth()) >= 0;
    }

    public List<Result> findOptimalCasesForOrders() {
        final List<Result> resultList = new ArrayList<>();
        findOptimalCasesForOrders(dataLoader.getOrders(), dataLoader.getCases())
                .forEach((key, value) -> resultList.add(new Result(key, value)));
        return resultList;
    }
}
