package com.witalis.praxis.leetcode.task.h19.p1887.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1887
 * Name: Reduction Operations to Make the Array Elements Equal
 * URL: <a href="https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/">Reduction Operations to Make the Array Elements Equal</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return reductionOperations(numbers);
    }

    public int reductionOperations(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        Arrays.sort(nums);

        int operations = 0;
        int counter = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                counter++;
            }
            operations = operations + counter;
        }

        return operations;
    }
}
