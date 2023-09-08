package com.witalis.praxis.leetcode.task.h26.p2506.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2506
 * Name: Count Pairs Of Similar Strings
 * URL: <a href="https://leetcode.com/problems/count-pairs-of-similar-strings/">Count Pairs Of Similar Strings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;

    public Integer process() {
        return similarPairs(words);
    }

    public int similarPairs(String[] words) {
        int ans = 0;
        int[] masks = new int[words.length];

        for (int i = 0; i < words.length; i++)
            masks[i] = getMask(words[i]);

        for (int i = 0; i < masks.length; i++)
            for (int j = i + 1; j < masks.length; j++)
                if (masks[i] == masks[j])
                    ++ans;

        return ans;
    }

    private int getMask(String word) {
        int mask = 0;
        for (char c : word.toCharArray())
            mask |= 1 << c - 'a';
        return mask;
    }
}
