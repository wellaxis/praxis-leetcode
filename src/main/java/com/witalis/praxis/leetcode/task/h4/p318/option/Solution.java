package com.witalis.praxis.leetcode.task.h4.p318.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 318
 * Name: Maximum Product of Word Lengths
 * URL: <a href="https://leetcode.com/problems/maximum-product-of-word-lengths/">Maximum Product of Word Lengths</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;

    public Integer process() {
        return maxProduct(words);
    }

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmask = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                // index: a -> 0, b -> 1, c -> 2 and so on
                int index = words[i].charAt(j) - 'a';
                // left shift 1 by index and OR it with the current bitmask
                bitmask[i] |= (1 << index);
            }

            // compare bitmask of current string with previous strings bitmask
            for (int j = 0; j < i; j++) {
                if ((bitmask[i] & bitmask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}
