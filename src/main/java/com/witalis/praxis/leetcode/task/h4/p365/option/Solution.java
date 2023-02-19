package com.witalis.praxis.leetcode.task.h4.p365.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * ID: 365
 * Name: Water and Jug Problem
 * URL: <a href="https://leetcode.com/problems/water-and-jug-problem/">Water and Jug Problem</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int capacity1;
    private int capacity2;
    private int capacity3;

    public Boolean process() {
        return canMeasureWater(capacity1, capacity2, capacity3);
    }

    // bfs
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity < 0 || targetCapacity > jug1Capacity + jug2Capacity) {
            return false;
        }

        final Set<Integer> visited = new HashSet<>();
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        final int[] options = new int[]{jug1Capacity, jug2Capacity, -jug1Capacity, -jug2Capacity};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == targetCapacity) {
                    return true;
                }
                for (int option : options) {
                    int next = current + option;
                    if (next < 0 || next > jug1Capacity + jug2Capacity) {
                        continue;
                    }
                    if (!visited.contains(next)) {
                        if (next == targetCapacity) {
                            return true;
                        }
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }

        return false;
    }

    // math
    public boolean canMeasureWaterMath(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // the first case
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;

        // the second case
        if (jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity)
            return true;

        // the third case: Bezout's identity
        if (targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0) return true;

        return false;
    }

    // greatest common divisor (GCD)
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
