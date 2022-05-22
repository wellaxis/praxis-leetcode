package com.witalis.praxis.leetcode.task.h3.p211.option;

import com.witalis.praxis.leetcode.task.h3.p211.content.IWordDictionary;
import com.witalis.praxis.leetcode.task.h3.p211.content.WordDictionaryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 211
 * Name: Design Add and Search Words Data Structure
 * URL: <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">Design Add and Search Words Data Structure</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public class WordDictionary implements IWordDictionary {
        TrieNode root;

        public class TrieNode {
            TrieNode[] arr;
            boolean isLeaf;

            public TrieNode() {
                arr = new TrieNode[26];
            }
        }

        public WordDictionary() {
            root = new TrieNode();
        }

        @Override
        public void addWord(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (p.arr[index] == null) {
                    TrieNode temp = new TrieNode();
                    p.arr[index] = temp;
                    p = temp;
                } else {
                    p = p.arr[index];
                }
            }

            p.isLeaf = true;
        }

        @Override
        public boolean search(String word) {
            return dfsSearch(root, word, 0);
        }

        public boolean dfsSearch(TrieNode p, String word, int start) {
            if (p.isLeaf && start == word.length()) return true;
            if (start >= word.length()) return false;

            char c = word.charAt(start);

            if (c == '.') {
                boolean tResult = false;
                for (int j = 0; j < 26; j++) {
                    if (p.arr[j] != null && dfsSearch(p.arr[j], word, start + 1)) {
                        tResult = true;
                        break;
                    }
                }

                return tResult;
            } else {
                int index = c - 'a';

                if (p.arr[index] != null) {
                    return dfsSearch(p.arr[index], word, start + 1);
                } else {
                    return false;
                }
            }
        }
    }

    public List<Boolean> process() {
        return WordDictionaryHandler.process(operations, new WordDictionary());
    }
}
