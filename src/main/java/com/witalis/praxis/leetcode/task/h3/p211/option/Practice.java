package com.witalis.praxis.leetcode.task.h3.p211.option;

import com.witalis.praxis.leetcode.task.h3.p211.content.IWordDictionary;
import com.witalis.praxis.leetcode.task.h3.p211.content.WordDictionaryHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 211
 * Name: Design Add and Search Words Data Structure
 * URL: <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">Design Add and Search Words Data Structure</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public class WordDictionary implements IWordDictionary {
        private WordDictionaryNode root;

        public class WordDictionaryNode {
            private char key;
            private String value;
            private Map<Character, WordDictionaryNode> dictionaries;

            public WordDictionaryNode() {
                this.dictionaries = new HashMap<>();
            }

            public WordDictionaryNode(char key) {
                this();
                this.key = key;
            }
        }

        public WordDictionary() {
            this.root = new WordDictionaryNode();
        }

        @Override
        public void addWord(String word) {
            if (word == null) return;

            WordDictionaryNode node = root;
            for (char symbol : word.toCharArray()) {
                if (!node.dictionaries.containsKey(symbol)) {
                    WordDictionaryNode subNode = new WordDictionaryNode(symbol);
                    node.dictionaries.put(symbol, subNode);
                }
                node = node.dictionaries.get(symbol);
            }

            node.value = word;
        }

        @Override
        public boolean search(String word) {
            return word != null && persist(root, word, 0);
        }

        private static boolean persist(WordDictionaryNode node, String word, int index) {
            if (node == null) return false;

            for (int i = index; i < word.length(); i++) {
                char symbol = word.charAt(i);
                if (symbol == '.') {
                    for (char key : node.dictionaries.keySet()) {
                        boolean existence = persist(node.dictionaries.get(key), word, i + 1);
                        if (existence) return true;
                    }
                    return false;
                } else {
                    if (!node.dictionaries.containsKey(symbol)) return false;
                    node = node.dictionaries.get(symbol);
                }
            }

            return node.value != null;
        }
    }

    public List<Boolean> process() {
        return WordDictionaryHandler.process(operations, new WordDictionary());
    }
}
