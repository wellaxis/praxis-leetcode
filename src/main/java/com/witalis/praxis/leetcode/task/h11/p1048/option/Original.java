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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;

    public Integer process() {
        return longestStrChain(words);
    }

    public int longestStrChain(String[] words) {
        if (words == null) return 0;

        final int n = words.length;

        Comparator<String> byMinLength = Comparator.comparingInt(String::length);
        Arrays.sort(words, byMinLength);

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String word : words) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }

        List<String>[] groups = new List[maxLen];
        for (int i = 0; i < maxLen; i++)
            groups[i] = new ArrayList<>();

        for (String word : words) {
            groups[word.length() - 1].add(word);
        }

        Map<String, List<String>> predecessors = new HashMap<>();
        for (int l = 0; l < maxLen - 1; l++) {
            List<String> groupA = groups[l];
            List<String> groupB = groups[l + 1];

            for (String wordA : groupA) {
                for (String wordB : groupB) {
                    if (isPredecessor(wordA, wordB)) {
                        predecessors.putIfAbsent(wordA, new ArrayList<>());
                        predecessors.get(wordA).add(wordB);
                    }
                }
            }
        }

        int longestChain = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (String predecessor : predecessors.keySet()) {
            int chain = solver(predecessors, memo, predecessor, 1);
            longestChain = Math.max(longestChain, chain);
        }

        return longestChain + 1;
    }

    private boolean isPredecessor(String s1, String s2) {
        final int n = s1.length();

        if (n + 1 != s2.length()) return false;

        boolean misMatch = false;
        for (int i = 0, j = 0; i < n; i++, j++) {
            if (s1.charAt(i) == s2.charAt(j)) continue;
            if (misMatch) return false;
            misMatch = true;
            i--;
        }

        return true;
    }

    private int solver(Map<String, List<String>> predecessors, Map<String, Integer> memo, String word, int chain) {
        if (!predecessors.containsKey(word)) return 0;
        if (memo.containsKey(word)) return memo.get(word);

        int maxChain = 0;
        for (String next : predecessors.get(word)) {
            int nextChain = solver(predecessors, memo, next, 1);
            maxChain = Math.max(maxChain, nextChain);
        }

        memo.put(word, chain + maxChain);

        return chain + maxChain;
    }
}
