package com.witalis.praxis.leetcode.task.h14.p1359.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ID: 1359
 * Name: Count All Valid Pickup and Delivery Options
 * URL: <a href="https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/">Count All Valid Pickup and Delivery Options</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int orders;

    public Original(int orders) {
        this.orders = orders;
    }

    public Integer process() {
        return countOrders(orders);
    }

    public static final int MOD = 1_000_000_007;

    enum OrderType {
        PICKUP,
        DELIVERY
    }

    record Order (int index, OrderType type) {}

    private int count = 0;

    public int countOrders(int n) {
        if (n <= 0) return 0;
        if (n > 10) {
            log.error("Time Limit Exceeded");
            return -1;
        }

        List<Order> orders = new ArrayList<>(2 * n);
        for (int i = 0; i < n; i++) {
            orders.add(new Order(i, OrderType.PICKUP));
            orders.add(new Order(i, OrderType.DELIVERY));
        }

        solver(n, orders, 0, new Stack<>());

        return count;
    }

    private void solver(int n, List<Order> orders, int index, Stack<Order> combination) {
        if (combination.size() == 2 * n) {
            count += 1 % MOD;
            return;
        }

        for (int i = 0; i < 2 * n; i++) {
            Order order = orders.get(i);

            if (combination.contains(order)) continue;
            if (order.type() == OrderType.DELIVERY) {
                if (!combination.contains(new Order(order.index(), OrderType.PICKUP))) continue;
            }

            combination.push(order);
            solver(n, orders, index + 1, combination);
            combination.pop();
        }
    }
}
