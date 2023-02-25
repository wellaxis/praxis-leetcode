package com.witalis.praxis.leetcode.task.h8.p739.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 739
 * Name: Daily Temperatures
 * URL: <a href="https://leetcode.com/problems/daily-temperatures/">Daily Temperatures</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] temperatures;

    public int[] process() {
        return dailyTemperatures(temperatures);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int hottest = Integer.MIN_VALUE;
        int[] answer = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (temperatures[i] >= hottest) {
                hottest = temperatures[i];
            } else {
                int nextIndex = i + 1;
                while (temperatures[nextIndex] <= temperatures[i]) {
                    nextIndex = nextIndex + answer[nextIndex];
                }
                answer[i] = nextIndex - i;
            }
        }

        return answer;
    }
}
