package com.witalis.praxis.leetcode.task.h9.p819.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 819
 * Name: Most Common Word
 * URL: <a href="https://leetcode.com/problems/most-common-word/">Most Common Word</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String paragraph;
    private String[] banned;

    public String process() {
        return mostCommonWord(paragraph, banned);
    }

    record Pair(String key, int value) {}

    public String mostCommonWord(String paragraph, String[] banned) {
        Pair ans = new Pair("", 0);
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");

        for (final String word : words)
            if (!bannedSet.contains(word)) {
                count.merge(word, 1, Integer::sum);
                if (count.get(word) > ans.value())
                    ans = new Pair(word, count.get(word));
            }

        return ans.key();
    }
}
