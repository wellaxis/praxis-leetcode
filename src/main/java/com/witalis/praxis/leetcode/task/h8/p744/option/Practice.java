package com.witalis.praxis.leetcode.task.h8.p744.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 744
 * Name: Find Smallest Letter Greater Than Target
 * URL: <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">Find Smallest Letter Greater Than Target</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[] letters;
    private char target;

    public Character process() {
        return nextGreatestLetter(letters, target);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) return 0;

        int index = 0;

        int left = 0;
        int right = letters.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                index = mid;
            }
        }

        return letters[index];
    }
}
