package com.witalis.praxis.leetcode.task.h11.p1005.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1005
 * Name: Maximize Sum Of Array After K Negations
 * URL: <a href="https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/">Maximize Sum Of Array After K Negations</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int negations;

    public Integer process() {
        return largestSumAfterKNegations(numbers, negations);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums == null) return 0;

        final int n = nums.length;
        final Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> (Integer.compare(Math.abs(b), Math.abs(a))));

        int sum = 0;
        boolean zeroes = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            } else if (arr[i] < 0) {
                if (k > 0) {
                    sum += -arr[i];
                    k--;
                } else {
                    sum += arr[i];
                }
            } else {
                zeroes = true;
            }
        }

        if (k > 0 && (k % 2 != 0) && !zeroes) {
            sum += 2 * arr[n - 1] * (arr[n - 1] > 0 ? -1 : 1);
        }

        return sum;
    }
}
