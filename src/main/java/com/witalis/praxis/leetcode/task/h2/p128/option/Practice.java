package com.witalis.praxis.leetcode.task.h2.p128.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 128
 * Name: Longest Consecutive Sequence
 * URL: <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Longest Consecutive Sequence</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return longestConsecutive(numbers);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLength = 0;

        Set<Integer> values = new HashSet<>();
        for (int num : nums) values.add(num);

        int length = 1;
        for (int num : nums) {
            if (!values.contains(num) || values.contains(num - 1)) continue;
            while (values.contains(num + 1)) {
                values.remove(num);
                length++;
                num++;
            }
            values.remove(num);
            if (length > maxLength) maxLength = length;
            length = 1;
        }

        return Math.max(maxLength, length);
    }
}
