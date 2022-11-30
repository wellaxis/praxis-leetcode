package com.witalis.praxis.leetcode.task.h13.p1207.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1207
 * Name: Unique Number of Occurrences
 * URL: <a href="https://leetcode.com/problems/unique-number-of-occurrences/">Unique Number of Occurrences</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return uniqueOccurrences(numbers);
    }

    public boolean uniqueOccurrences(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] frequency = new int[max - min + 1];
        int[] uniqueness = new int[arr.length + 1];

        for (int num : arr) {
            frequency[num - min]++;
        }

        for (int num : frequency) {
            if (num > 0) {
                if (uniqueness[num] > 0) return false;
                uniqueness[num]++;
            }
        }

        return true;
    }
}
