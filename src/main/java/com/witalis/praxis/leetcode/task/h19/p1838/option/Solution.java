package com.witalis.praxis.leetcode.task.h19.p1838.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1838
 * Name: Frequency of the Most Frequent Element
 * URL: <a href="https://leetcode.com/problems/frequency-of-the-most-frequent-element/">Frequency of the Most Frequent Element</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int operations;

    public Integer process() {
        return maxFrequency(numbers, operations);
    }

    public int maxFrequency(int[] nums, int k) {
        countingSort(nums);

        int start = 0;
        int preSum = 0;
        int total = 1;
        for (int i = 0; i < nums.length; i++) {
            int length = i - start + 1;
            int product = nums[i] * length;

            preSum += nums[i];
            while (product - preSum > k) {
                preSum -= nums[start++];
                length--;
                product = nums[i] * length;
            }
            total = Math.max(total, length);
        }

        return total;
    }

    private void countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }

        int[] map = new int[max + 1];
        for(int num: nums) {
            map[num]++;
        }

        int i = 0;
        int j = 0;
        while(i <= max) {
            if (map[i]-- > 0) {
                nums[j++] = i;
            } else {
                i++;
            }
        }
    }
}
