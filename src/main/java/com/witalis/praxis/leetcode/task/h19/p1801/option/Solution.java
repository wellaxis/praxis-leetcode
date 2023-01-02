package com.witalis.praxis.leetcode.task.h19.p1801.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1801
 * Name: Number of Orders in the Backlog
 * URL: <a href="https://leetcode.com/problems/number-of-orders-in-the-backlog/">Number of Orders in the Backlog</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] orders;

    public Integer process() {
        return getNumberOfBacklogOrders(orders);
    }

    static final int mod = 1000000007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        Queue<int[]> bb = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Queue<int[]> sb = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int c = 0;
        for (int[] o : orders) {
            if (o[2] == 0) {
                while (o[1] > 0 && !sb.isEmpty() && sb.peek()[0] <= o[0]) {
                    if (sb.peek()[1] <= o[1]) {
                        o[1] -= sb.peek()[1];
                        c = (c + mod - sb.poll()[1]) % mod;
                    } else {
                        sb.peek()[1] -= o[1];
                        c = (c + mod - o[1]) % mod;
                        o[1] = 0;
                    }
                }
                if (o[1] > 0) {
                    bb.offer(o);
                    c = (c + o[1]) % mod;
                }
            } else {
                while (o[1] > 0 && !bb.isEmpty() && bb.peek()[0] >= o[0]) {
                    if (bb.peek()[1] <= o[1]) {
                        o[1] -= bb.peek()[1];
                        c = (c + mod - bb.poll()[1]) % mod;
                    } else {
                        bb.peek()[1] -= o[1];
                        c = (c + mod - o[1]) % mod;
                        o[1] = 0;
                    }
                }
                if (o[1] > 0) {
                    sb.offer(o);
                    c = (c + o[1]) % mod;
                }
            }
        }

        return c;
    }
}
