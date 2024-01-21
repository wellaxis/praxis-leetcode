package com.witalis.praxis.leetcode.task.h10.p907.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * ID: 907
 * Name: Sum of Subarray Minimums
 * URL: <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">Sum of Subarray Minimums</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] array;

    public Integer process() {
        return sumSubarrayMins(array);
    }

    public static final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        if (arr == null) return 0;

        final int n = arr.length;

        final int[] left = new int[n];
        final int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        long sum = 0L;

        for (int i = 0; i < n; ++i) {
            sum += (long) (i - left[i]) * (right[i] - i) % MOD * arr[i] % MOD;
            sum %= MOD;
        }

        return (int) sum;
    }
}
