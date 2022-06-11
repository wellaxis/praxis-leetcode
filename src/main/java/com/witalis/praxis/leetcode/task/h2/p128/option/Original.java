package com.witalis.praxis.leetcode.task.h2.p128.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * ID: 128
 * Name: Longest Consecutive Sequence
 * URL: <a href="https://leetcode.com/problems/longest-consecutive-sequence/">Longest Consecutive Sequence</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return longestConsecutive(numbers);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLength = 1;

        Set<Integer> values = new TreeSet<>(Integer::compareTo);
        for (int num : nums) values.add(num);

        int length = 1;
        Iterator<Integer> iterator = values.iterator();
        int current = iterator.next();
        int previous = current;
        while (iterator.hasNext()) {
            current = iterator.next();
            if (current == previous + 1) {
                length++;
            } else {
                if (length > maxLength) maxLength = length;
                length = 1;
            }
            previous = current;
        }

        return Math.max(maxLength, length);
    }
}
