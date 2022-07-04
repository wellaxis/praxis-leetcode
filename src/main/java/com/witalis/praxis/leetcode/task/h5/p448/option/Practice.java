package com.witalis.praxis.leetcode.task.h5.p448.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 448
 * Name: Find All Numbers Disappeared in an Array
 * URL: <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">Find All Numbers Disappeared in an Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<Integer> process() {
        return findDisappearedNumbers(numbers);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) list.add(i + 1);
        }

        return list;
    }
}
