package com.witalis.praxis.leetcode.task.h10.p904.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 904
 * Name: Fruit Into Baskets
 * URL: <a href="https://leetcode.com/problems/fruit-into-baskets/">Fruit Into Baskets</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] fruits;

    public Integer process() {
        return totalFruit(fruits);
    }

    public int totalFruit(int[] fruits) {
        // we use a hash map 'basket' to store the number of each type of fruit.
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxPicked = 0;

        // add fruit from the right index (right) of the window.
        for (int right = 0; right < fruits.length; ++right) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            // if the current window has more than 2 types of fruit,
            // we remove fruit from the left index (left) of the window,
            // until the window has only 2 types of fruit.
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }

            // update maxPicked.
            maxPicked = Math.max(maxPicked, right - left + 1);
        }

        // return maxPicked as the maximum number of fruits we can collect.
        return maxPicked;
    }
}
