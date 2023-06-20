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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int radius;

    public int[] process() {
        return getAverages(numbers, radius);
    }

    public int[] getAverages(int[] nums, int k) {
        if (nums == null || k < 0) return new int[0];

        final int n = nums.length;
        final int[] averages = new int[n];
        Arrays.fill(averages, -1);

        final int divisor = 2 * k + 1;
        if (divisor > n) return averages;

        long sum = 0L;
        for (int i = 0; i < divisor; i++)
            sum += nums[i];
        averages[k] = (int) (sum / divisor);

        for (int i = k + 1; i < n - k; i++) {
            sum -= nums[i - k - 1];
            sum += nums[i + k];
            averages[i] = (int) (sum / divisor);
        }

        return averages;
    }
}
