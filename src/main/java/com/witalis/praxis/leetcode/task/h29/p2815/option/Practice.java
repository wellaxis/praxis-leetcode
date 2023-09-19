package com.witalis.praxis.leetcode.task.h29.p2815.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2815
 * Name: Max Pair Sum in an Array
 * URL: <a href="https://leetcode.com/problems/max-pair-sum-in-an-array/">Max Pair Sum in an Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return maxSum(numbers);
    }

    public static final int DIGITS = 10;

    public int maxSum(int[] nums) {
        if (nums == null) return -1;

        int[][] heaps = new int[DIGITS][2];
        for (int[] heap : heaps) Arrays.fill(heap, -1);

        for (int num : nums) {
            int digit = maxDigit(num);
            if (num > heaps[digit][0]) {
                heaps[digit][1] = heaps[digit][0];
                heaps[digit][0] = num;
            } else if (num > heaps[digit][1]) {
                heaps[digit][1] = num;
            }
        }

        int sum = -1;
        for (int[] heap : heaps)
            if (heap[0] > -1 && heap[1] > -1)
                sum = Math.max(sum, heap[0] + heap[1]);

        return sum;
    }

    private int maxDigit(int num) {
        boolean[] seen = new boolean[DIGITS];

        while (num > 0) {
            seen[num % 10] = true;
            num /= 10;
        }

        for (int i = DIGITS - 1; i >= 0; i--)
            if (seen[i]) return i;

        return -1;
    }
}
