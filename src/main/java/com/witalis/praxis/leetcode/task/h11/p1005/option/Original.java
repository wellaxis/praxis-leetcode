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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int negations;

    public Integer process() {
        return largestSumAfterKNegations(numbers, negations);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums == null) return 0;

        final int n = nums.length;
        final int[] arr = Arrays.stream(nums)
            .boxed()
            .sorted((a,b) -> (Integer.compare(Math.abs(b),  Math.abs(a))))
            .mapToInt(Integer::intValue)
            .toArray();

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
            sum += arr[n - 1] * ((arr[n - 1] > 0) ? -2 : 2);
        }

        return sum;
    }
}
