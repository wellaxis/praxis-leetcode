package com.witalis.praxis.leetcode.task.h10.p904.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 904
 * Name: Fruit Into Baskets
 * URL: <a href="https://leetcode.com/problems/fruit-into-baskets/">Fruit Into Baskets</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] fruits;

    public Integer process() {
        return totalFruit(fruits);
    }

    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;

        final int len = fruits.length;

        int total = 0;

        int[] previous = new int[] {-1, -1};
        int[] current = new int[] {fruits[0], 1};
        for (int i = 1; i < len; i++) {
            if (fruits[i] == current[0]) {
                current[1]++;
                continue;
            } else if (fruits[i] == previous[0] || previous[0] == -1) {
                current[1]++;
            } else {
                total = Math.max(total, current[1]);
                current[1] = i - previous[1] + 1;
            }
            previous[0] = current[0];
            previous[1] = i;
            current[0] = fruits[i];
        }
        total = Math.max(total, current[1]);

        return total;
    }
}
