package com.witalis.praxis.leetcode.task.h19.p1838.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1838
 * Name: Frequency of the Most Frequent Element
 * URL: <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/">Frequency of the Most Frequent Element</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int operations;

    public Integer process() {
        return maxFrequency(numbers, operations);
    }

    public int maxFrequency(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return 0;

        Arrays.sort(nums);

        int maxFrequency = 0;

        int left = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while ((long) nums[right] * (right - left + 1) > sum + k) {
                sum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}
