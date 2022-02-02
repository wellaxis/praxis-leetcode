package com.witalis.praxis.leetcode.task.h2.p169.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 169
 * Name: Majority Element
 * URL: https://leetcode.com/problems/majority-element/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return majorityElement(numbers);
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter++;
            if (counter > nums.length / 2) return nums[i];
            if (nums[i] != nums[i + 1]) counter = 0;
        }

        throw new IllegalArgumentException("Majority element is absent");
    }
}
