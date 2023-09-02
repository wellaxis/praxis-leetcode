package com.witalis.praxis.leetcode.task.h28.p2707.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2707
 * Name: Extra Characters in a String
 * URL: <a href="https://leetcode.com/problems/extra-characters-in-a-string/">Extra Characters in a String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private String[] dictionary;

    public Solution(String string, String[] dictionary) {
        this.string = string;
        this.dictionary = dictionary;
    }

    public Integer process() {
        return minExtraChar(string, dictionary);
    }

    class Trie {
        private TrieNode root;

        public Trie(String[] dictionary) {
            this.root = build(dictionary);
        }

        public TrieNode getRoot() {
            return root;
        }

        class TrieNode {
            Map<Character, TrieNode> children = new HashMap();
            boolean isWord = false;
        }

        private TrieNode build(String[] dictionary) {
            TrieNode root = new TrieNode();
            for (String word : dictionary) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    node.children.putIfAbsent(c, new TrieNode());
                    node = node.children.get(c);
                }
                node.isWord = true;
            }
            return root;
        }
    }

    private Trie trie;
    private Integer[] memo;

    public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();

        this.trie = new Trie(dictionary);
        this.memo = new Integer[n + 1];

        return dp(0, n, s);
    }

    private int dp(int start, int n, String s) {
        if (start == n) return 0;
        if (memo[start] != null) return memo[start];

        Trie.TrieNode node = trie.getRoot();

        // count this character as a leftover character move to index 'start + 1'
        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            char c = s.charAt(end);
            if (!node.children.containsKey(c)) break;

            node = node.children.get(c);
            if (node.isWord) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }

        return memo[start] = ans;
    }
}
