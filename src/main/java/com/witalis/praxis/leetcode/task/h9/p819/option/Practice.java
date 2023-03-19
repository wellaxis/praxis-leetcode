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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String paragraph;
    private String[] banned;

    public String process() {
        return mostCommonWord(paragraph, banned);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || banned == null) return "";

        final Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        final String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");

        final Map<String, Integer> frequency = new HashMap<>();
        for (final String word : words)
            if (!word.isEmpty() && !bannedWords.contains(word))
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);

        final List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return entries.get(0).getKey();
    }
}
