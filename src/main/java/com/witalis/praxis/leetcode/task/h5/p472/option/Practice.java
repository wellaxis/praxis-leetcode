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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;

    public List<String> process() {
        return findAllConcatenatedWordsInADict(words);
    }

    class Trie {
        public static final int LETTERS = 26;
        private Node root;

        public Trie() {
            this.root = new Node();
        }

        class Node {
            private Node[] next;
            private boolean isEnd;

            public Node() {
                this.next = new Node[LETTERS];
                this.isEnd = false;
            }
        }

        private void insert(String word) {
            Node current = root;

            for (char ch : word.toCharArray()) {
                if (current.next[ch - 'a'] == null) {
                    current.next[ch - 'a'] = new Node();
                }
                current = current.next[ch - 'a'];
            }
            current.isEnd = true;
        }

        public boolean isConcatenated(String word) {
            boolean concatenated = isConcatenated(word, 0);
            insert(word);

            return concatenated;
        }

        private boolean isConcatenated(String word, int index) {
            final int len = word.length();
            if (index == len) return true;

            Node current = root;
            for (int i = index; i < len; i++) {
                final char ch = word.charAt(i);
                if (current.next[ch - 'a'] != null) {
                    current = current.next[ch - 'a'];
                    if (current.isEnd && isConcatenated(word, i + 1)) return true;
                } else {
                    break;
                }
            }

            return false;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length == 0) return Collections.emptyList();

        final Trie trie = new Trie();

        Arrays.sort(words, Comparator.comparingInt(String::length));

        return Arrays.stream(words).filter(trie::isConcatenated).toList();
    }
}
