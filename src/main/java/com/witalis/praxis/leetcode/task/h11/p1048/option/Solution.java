package com.witalis.praxis.leetcode.task.h11.p1048.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1048
 * Name: Longest String Chain
 * URL: <a href="https://leetcode.com/problems/longest-string-chain/">Longest String Chain</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;

    public Solution(String[] words) {
        this.words = words;
    }

    public Integer process() {
        return longestStrChain(words);
    }

    private Map<String, Integer> dp = new HashMap<>();
    private Set<String> wordsSet = new HashSet<>();

    public int longestStrChain(String[] words) {
        wordsSet.addAll(Arrays.asList(words));

        int ans = 0;
        for (final String word : words)
            ans = Math.max(ans, longestStrChain(word));

        return ans;
    }

    private int longestStrChain(final String s) {
        if (dp.containsKey(s)) return dp.get(s);

        int ans = 1;

        for (int i = 0; i < s.length(); ++i) {
            final String pred = s.substring(0, i) + s.substring(i + 1);
            if (wordsSet.contains(pred))
                ans = Math.max(ans, longestStrChain(pred) + 1);
        }

        dp.put(s, ans);

        return ans;
    }
}
