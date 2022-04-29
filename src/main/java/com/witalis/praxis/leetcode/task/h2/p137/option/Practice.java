package com.witalis.praxis.leetcode.task.h2.p137.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 137
 * Name: Single Number II
 * URL: <a href="https://leetcode.com/problems/single-number-ii/">Single Number II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return singleNumber(numbers);
    }

    public int singleNumber(int[] nums) {
        // xor (exclusive or): a^a = 0, a^b^a = b.
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        Set<Integer> multiples = new HashSet<>();

        int number = 0;
        for (int num : nums) {
            number ^= num;
            if (!multiples.contains(num)) {
                multiples.add(num);
            } else {
                number ^= num;
                multiples.remove(num);
            }
        }

        return number;
    }
}
