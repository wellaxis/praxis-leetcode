package com.witalis.praxis.leetcode.task.h15.p1402.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1402
 * Name: Reducing Dishes
 * URL: <a href="https://leetcode.com/problems/reducing-dishes/">Reducing Dishes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] satisfaction;

    public Integer process() {
        return maxSatisfaction(satisfaction);
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int maxSatisfaction = 0;
        int suffixSum = 0;
        for (int i = satisfaction.length - 1; i >= 0 && suffixSum + satisfaction[i] > 0; i--) {
            // total satisfaction with all dishes so far
            suffixSum += satisfaction[i];
            // adding one instance of previous dishes as we add one more dish on the left
            maxSatisfaction +=  suffixSum;
        }

        return maxSatisfaction;
    }
}
