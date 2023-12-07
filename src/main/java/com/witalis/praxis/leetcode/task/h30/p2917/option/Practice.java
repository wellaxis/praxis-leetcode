package com.witalis.praxis.leetcode.task.h30.p2917.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2917
 * Name: Find the K-or of an Array
 * URL: <a href="https://leetcode.com/problems/find-the-k-or-of-an-array/">Find the K-or of an Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int elements;

    public Integer process() {
        return findKOr(numbers, elements);
    }

    public int findKOr(int[] nums, int k) {
        if (nums == null || k <= 0) return 0;

        int value = 0;

        for (int i = 0; i < 31; i++) {
            int position = (1 << i);
            int counter = 0;

            for (int element : nums)
                if ((position & element) != 0)
                    counter++;

            if (counter >= k) value += position;
        }

        return value;
    }
}
