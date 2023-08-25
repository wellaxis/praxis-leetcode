package com.witalis.praxis.leetcode.task.h9.p884.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 884
 * Name: Uncommon Words from Two Sentences
 * URL: <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/">Uncommon Words from Two Sentences</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string1;
    private String string2;

    public String[] process() {
        return uncommonFromSentences(string1, string2);
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> set = new HashSet<>();
        Set<String> removedSet = new HashSet<>();

        addWords(set, removedSet, s1);
        addWords(set, removedSet, s2);

        return set.toArray(new String[0]);
    }

    private static void addWords(Set<String> set, Set<String> removedSet, String s) {
        for (String word : s.split(" "))
            if (set.contains(word)) {
                set.remove(word);
                removedSet.add(word);
            } else if (!removedSet.contains(word))
                set.add(word);
    }
}
