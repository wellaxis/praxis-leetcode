package com.witalis.praxis.leetcode.task.h1.p15.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 15
 * Name: 3Sum
 * URL: <a href="https://leetcode.com/problems/3sum/">3Sum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<List<Integer>> process() {
        return threeSum(numbers);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int left, right, i, sum;

        List<List<Integer>> rt = new ArrayList<>();

        if (nums.length < 3) return rt;

        Arrays.sort(nums);

        for (i = 0; i < nums.length - 2; i++) {
            sum = 0 - nums[i];
            left = i + 1;
            right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == sum ) {
                    rt.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[1 + left]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < sum) {
                    left++;
                } else{
                    right--;
                }
            }

            while(i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }
        return rt;
    }
}
