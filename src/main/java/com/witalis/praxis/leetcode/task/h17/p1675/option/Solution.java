package com.witalis.praxis.leetcode.task.h17.p1675.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.TreeSet;

/**
 * ID: 1675
 * Name: Minimize Deviation in Array
 * URL: <a href="https://leetcode.com/problems/minimize-deviation-in-array/">Minimize Deviation in Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return minimumDeviation(numbers);
    }

    public int minimumDeviation(int[] nums) {
        final TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if ((num) % 2 == 1) {
                set.add(2 * num);
            } else {
                set.add(num);
            }
        }

        int deviation = (int) 1e9;
        while (true) {
            int max = set.last();
            int min = set.first();
            int diff = max - min;

            deviation = Math.min(deviation, diff);
            if (max % 2 == 0) {
                set.remove(max);
                set.add(max / 2);
            } else {
                return deviation;
            }
        }
    }
}
