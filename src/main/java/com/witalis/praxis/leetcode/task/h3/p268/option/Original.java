package com.witalis.praxis.leetcode.task.h3.p268.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 268
 * Name: Missing Number
 * URL: <a href="https://leetcode.com/problems/missing-number/">Missing Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return missingNumber(numbers);
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int progression = len * (1 + len) / 2;
        int sum = (int) Arrays.stream(nums).summaryStatistics().getSum();

        return progression - sum;
    }
}
