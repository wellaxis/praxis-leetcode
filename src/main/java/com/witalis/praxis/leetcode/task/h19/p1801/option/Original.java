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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] orders;

    public Integer process() {
        return getNumberOfBacklogOrders(orders);
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        final int MOD = (int) Math.pow(10, 9) + 7;

        if (orders == null || orders.length == 0) return 0;

        int number = 0;

        Comparator<int[]> buyComparing = Comparator.comparingInt((int[] price) -> price[0]).reversed();
        Comparator<int[]> sellComparing = Comparator.comparingInt((int[] price) -> price[0]);
        Queue<int[]> buys = new PriorityQueue<>(buyComparing);
        Queue<int[]> sells = new PriorityQueue<>(sellComparing);
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            if (type == 0) {
                // buy
                while (!sells.isEmpty() && sells.peek()[0] <= price) {
                    int[] sell = sells.poll();
                    if (sell[1] > amount) {
                        sell[1] -= amount;
                        sells.offer(sell);
                        amount = 0;
                        break;
                    } else {
                        amount -= sell[1];
                    }
                }
                if (amount > 0) {
                    buys.offer(new int[] {price, amount});
                }
            } else if (type == 1) {
                // sell
                while (!buys.isEmpty() && buys.peek()[0] >= price) {
                    int[] buy = buys.poll();
                    if (buy[1] > amount) {
                        buy[1] -= amount;
                        buys.offer(buy);
                        amount = 0;
                        break;
                    } else {
                        amount -= buy[1];
                    }
                }
                if (amount > 0) {
                    sells.offer(new int[] {price, amount});
                }
            }
        }

        for (int[] buy : buys) {
            number = (number + buy[1]) % MOD;
        }
        for (int[] sell : sells) {
            number = (number + sell[1]) % MOD;
        }

        return number % MOD;
    }
}
