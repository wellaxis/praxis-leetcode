package com.witalis.praxis.leetcode.task.h3.p208.option;

import com.witalis.praxis.leetcode.task.h3.p208.content.ITrie;
import com.witalis.praxis.leetcode.task.h3.p208.content.TrieHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 208
 * Name: Implement Trie (Prefix Tree)
 * URL: <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">Implement Trie (Prefix Tree)</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public class Trie implements ITrie {
        private TrieNode root;

        class TrieNode {
            private final int R = 26;

            private TrieNode[] links;
            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch -'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch -'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch -'a'] = node;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }

        public Trie() {
            this.root = new TrieNode();
        }

        @Override
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        @Override
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }

        @Override
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }

    public List<Boolean> process() {
        return TrieHandler.process(operations, new Trie());
    }
}
