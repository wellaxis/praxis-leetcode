package com.witalis.praxis.leetcode.task.h3.p229.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 229
 * Name: Majority Element II
 * URL: <a href="https://leetcode.com/problems/majority-element-ii/">Majority Element II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<Integer> process() {
        return majorityElement(numbers);
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> elements = new ArrayList<>();

        Arrays.sort(nums);
        final int len = nums.length;
        final int frequency = len / 3;

        int counter = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                counter++;
            } else {
                if (counter > frequency) elements.add(nums[i - 1]);
                counter = 1;
            }
        }
        if (counter > frequency) elements.add(nums[len - 1]);

        return elements;
    }
}
