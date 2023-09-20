package com.witalis.praxis.leetcode.task.h17.p1658.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1658
 * Name: Minimum Operations to Reduce X to Zero
 * URL: <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">Minimum Operations to Reduce X to Zero</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int number;

    public Integer process() {
        return minOperations(numbers, number);
    }

    public int minOperations(int[] nums, int x) {
        if (nums == null || x < 0) return -1;

        final int n = nums.length;

        final int total = Arrays.stream(nums).sum();
        final int difference = total - x;

        if (difference < 0) return -1;
        if (difference == 0) return n;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);

        int minOperations = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - difference)) {
                minOperations = Math.max(minOperations, i - map.get(sum - difference));
            }
            map.putIfAbsent(sum, i);
        }

        return minOperations == 0 ? -1 : n - minOperations;
    }
}
