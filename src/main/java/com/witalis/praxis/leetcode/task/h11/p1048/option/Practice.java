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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Practice {
    private String[] words;

    public Practice(String[] words) {
        this.words = words;
    }

    public Integer process() {
        return longestStrChain(words);
    }

    private Map<String, List<String>> predecessors;
    private Map<String, Integer> memo;

    public int longestStrChain(String[] words) {
        if (words == null) return 0;

        this.predecessors = new HashMap<>();
        this.memo = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;
        for (String word : words)
            maxLen = Math.max(maxLen, word.length());

        List<String>[] groups = new List[maxLen];
        for (int i = 0; i < maxLen; i++)
            groups[i] = new ArrayList<>();

        for (String word : words)
            groups[word.length() - 1].add(word);

        for (int l = 0; l < maxLen - 1; l++) {
            List<String> groupA = groups[l];
            List<String> groupB = groups[l + 1];

            for (String wordA : groupA)
                for (String wordB : groupB)
                    if (isPredecessor(wordA, wordB))
                        predecessors.computeIfAbsent(wordA, w -> new ArrayList<>()).add(wordB);
        }

        int longestChain = 0;
        for (String predecessor : predecessors.keySet())
            longestChain = Math.max(longestChain, solver(predecessor));

        return longestChain + 1;
    }

    private boolean isPredecessor(String s1, String s2) {
        final int n = s1.length();

        boolean misMatch = false;
        for (int i = 0, j = 0; i < n; i++, j++) {
            if (s1.charAt(i) == s2.charAt(j)) continue;
            if (misMatch) return false;
            misMatch = true;
            i--;
        }

        return true;
    }

    private int solver(String word) {
        if (!predecessors.containsKey(word)) return 0;
        if (memo.containsKey(word)) return memo.get(word);

        int maxChain = 0;
        for (String next : predecessors.get(word))
            maxChain = Math.max(maxChain, solver(next));

        memo.put(word, maxChain + 1);

        return maxChain + 1;
    }
}
