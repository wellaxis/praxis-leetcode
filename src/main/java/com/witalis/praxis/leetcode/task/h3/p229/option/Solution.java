package com.witalis.praxis.leetcode.task.h3.p229.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 229
 * Name: Majority Element II
 * URL: <a href="https://leetcode.com/problems/majority-element-ii/">Majority Element II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<Integer> process() {
        return majorityElement(numbers);
    }

    // Boyer–Moore majority vote algorithm
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        // 1st pass
        Integer candidate1 = null;
        Integer candidate2 = null;

        int count1 = 0;
        int count2 = 0;
        for (int n : nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (candidate1 != null && n == candidate1) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}
