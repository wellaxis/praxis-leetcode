package com.witalis.praxis.leetcode.task.h5.p472.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 472
 * Name: Concatenated Words
 * URL: <a href="https://leetcode.com/problems/concatenated-words/">Concatenated Words</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;

    public List<String> process() {
        return findAllConcatenatedWordsInADict(words);
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        final List<String> answer = new ArrayList<>();

        for (final String word : words) {
            final int length = word.length();
            final boolean[] dp = new boolean[length + 1];

            dp[0] = true;
            for (int i = 1; i <= length; ++i) {
                for (int j = (i == length ? 1 : 0); !dp[i] && j < i; ++j) {
                    dp[i] = dp[j] && dictionary.contains(word.substring(j, i));
                }
            }
            if (dp[length]) {
                answer.add(word);
            }
        }

        return answer;
    }
}
