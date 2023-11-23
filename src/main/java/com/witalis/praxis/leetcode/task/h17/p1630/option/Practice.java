package com.witalis.praxis.leetcode.task.h17.p1630.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 1630
 * Name: Arithmetic Subarrays
 * URL: <a href="https://leetcode.com/problems/arithmetic-subarrays/">Arithmetic Subarrays</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int[] left;
    private int[] right;

    public List<Boolean> process() {
        return checkArithmeticSubarrays(numbers, left, right);
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        if (nums == null || l == null || r == null) return Collections.emptyList();

        final int m = l.length;

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++)
            ans.add(helper(Arrays.copyOfRange(nums, l[i], r[i] + 1)));

        return ans;
    }

    private static boolean helper(int[] arr) {
        final int n = arr.length;

        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++)
            if ((arr[i + 1] - arr[i]) != (arr[1] - arr[0]))
                return false;

        return true;
    }
}
