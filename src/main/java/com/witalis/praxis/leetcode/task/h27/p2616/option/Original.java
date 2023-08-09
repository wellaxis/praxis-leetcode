package com.witalis.praxis.leetcode.task.h27.p2616.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2616
 * Name: Minimize the Maximum Difference of Pairs
 * URL: <a href="https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/">Minimize the Maximum Difference of Pairs</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int pairs;

    public Integer process() {
        return minimizeMax(numbers, pairs);
    }

    public int minimizeMax(int[] nums, int p) {
        if (nums == null || p <= 0) return 0;

        final int n = nums.length;

        Arrays.sort(nums);

        int min = 0;
        int max = nums[n - 1] - nums[0];
        while (min < max) {
            int mid = min + (max - min) / 2;

            int pairs = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    pairs++;
                    i++;
                }
            }

            if (pairs >= p) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}
