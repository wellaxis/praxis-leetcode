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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public class Trie implements ITrie {
        private TrieNode root;

        public class TrieNode {
            private char key;
            private String value;
            private Map<Character, TrieNode> tries;

            public TrieNode() {
                this.tries = new HashMap<>();
            }

            public TrieNode(char key) {
                this();
                this.key = key;
            }
        }

        public Trie() {
            this.root = new TrieNode();
        }

        @Override
        public void insert(String word) {
            if (word == null) return;

            TrieNode node = root;
            for (char symbol : word.toCharArray()) {
                if (!node.tries.containsKey(symbol)) {
                    TrieNode subNode = new TrieNode(symbol);
                    node.tries.put(symbol, subNode);
                }
                node = node.tries.get(symbol);
            }

            node.value = word;
        }

        @Override
        public boolean search(String word) {
            if (word == null) return false;

            TrieNode node = root;
            for (char symbol : word.toCharArray()) {
                if (!node.tries.containsKey(symbol)) return false;
                node = node.tries.get(symbol);
            }

            return node.value != null;
        }

        @Override
        public boolean startsWith(String prefix) {
            if (prefix == null) return false;

            TrieNode node = root;
            for (char symbol : prefix.toCharArray()) {
                if (!node.tries.containsKey(symbol)) return false;
                node = node.tries.get(symbol);
            }

            return node != null;
        }
    }

    public List<Boolean> process() {
        return TrieHandler.process(operations, new Trie());
    }
}
