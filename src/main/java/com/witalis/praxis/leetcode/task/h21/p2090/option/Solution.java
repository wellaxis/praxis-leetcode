package com.witalis.praxis.leetcode.task.h21.p2090.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2090
 * Name: K Radius Subarray Averages
 * URL: <a href="https://leetcode.com/problems/k-radius-subarray-averages/">K Radius Subarray Averages</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int radius;

    public int[] process() {
        return getAverages(numbers, radius);
    }

    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];
        Arrays.fill(avgs, -1);

        if (2 * k + 1 > nums.length) {
            return avgs;
        }

        double sum = 0;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }

        double avg = sum / (2 * k + 1);
        avgs[k] = (int) avg;

        for (int i = 2 * k + 1, c = 0; i < nums.length; i++, c++) {
            sum += nums[i];
            sum -= nums[c];

            avg = sum / (2 * k + 1);
            avgs[k + c + 1] = (int) avg;
        }

        return avgs;
    }
}
