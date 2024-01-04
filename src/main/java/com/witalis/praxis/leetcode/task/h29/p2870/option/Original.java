package com.witalis.praxis.leetcode.task.h29.p2870.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 2870
 * Name: Minimum Number of Operations to Make Array Empty
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/">Minimum Number of Operations to Make Array Empty</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return minOperations(numbers);
    }

    public int minOperations(int[] nums) {
        if (nums == null) return -1;

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums)
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);

        if (frequencies.values().stream().anyMatch(value -> value == 1)) return -1;

        return frequencies.values().stream().map(Original::calculateOperations).mapToInt(Integer::intValue).sum();
    }

    private static int calculateOperations(int num) {
        return (int) Math.ceil((double) num / 3);
    }
}
