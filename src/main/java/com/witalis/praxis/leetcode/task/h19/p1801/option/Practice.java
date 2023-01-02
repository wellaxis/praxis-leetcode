package com.witalis.praxis.leetcode.task.h19.p1801.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1801
 * Name: Number of Orders in the Backlog
 * URL: <a href="https://leetcode.com/problems/number-of-orders-in-the-backlog/">Number of Orders in the Backlog</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] orders;

    public Integer process() {
        return getNumberOfBacklogOrders(orders);
    }

    private static final int MOD = 1_000_000_007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        final int PRICE = 0;
        final int AMOUNT = 1;
        final int TYPE = 2;

        if (orders == null || orders.length == 0) return 0;

        final Comparator<int[]> priceComparing = Comparator.comparingInt((int[] price) -> price[PRICE]);
        final Queue<int[]> buys = new PriorityQueue<>(priceComparing.reversed());
        final Queue<int[]> sells = new PriorityQueue<>(priceComparing);

        for (int[] order : orders) {
            switch (order[TYPE]) {
                case 0 -> buys.offer(order);
                case 1 -> sells.offer(order);
            }
            while (!buys.isEmpty() && !sells.isEmpty() && buys.peek()[PRICE] >= sells.peek()[PRICE]) {
                int amount = Math.min(buys.peek()[AMOUNT], sells.peek()[AMOUNT]);
                buys.peek()[AMOUNT] -= amount;
                sells.peek()[AMOUNT] -= amount;
                if (buys.peek()[AMOUNT] == 0) buys.poll();
                if (sells.peek()[AMOUNT] == 0) sells.poll();
            }
        }

        long number = 0;
        for (int[] buy : buys) number = (number + buy[1]) % MOD;
        for (int[] sell : sells) number = (number + sell[1]) % MOD;

        return (int) number % MOD;
    }
}
