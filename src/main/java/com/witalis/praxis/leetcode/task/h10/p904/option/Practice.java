package com.witalis.praxis.leetcode.task.h10.p904.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ID: 904
 * Name: Fruit Into Baskets
 * URL: <a href="https://leetcode.com/problems/fruit-into-baskets/">Fruit Into Baskets</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] fruits;

    public Integer process() {
        return totalFruit(fruits);
    }

    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;

        final int len = fruits.length;

        int total = 0;
        int previous = -1;
        int current = fruits[0];
        int sum = 1;
        int index = -1;
        for (int i = 1; i < len; i++) {
            if (fruits[i] == current) {
                sum++;
                continue;
            } else if (fruits[i] == previous || previous == -1) {
                sum++;
            } else {
                total = Math.max(total, sum);
                sum = i - index + 1;
            }
            previous = current;
            current = fruits[i];
            index = i;
        }

        return Math.max(total, sum);
    }
}
