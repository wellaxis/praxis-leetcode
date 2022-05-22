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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public class WordDictionary implements IWordDictionary {
        private char key;
        private String value;
        private Map<Character, WordDictionary> dictionaries;

        public WordDictionary() {
            this.dictionaries = new HashMap<>();
        }

        @Override
        public void addWord(String word) {
            if (word == null) return;

            WordDictionary dictionary = this;
            for (char symbol : word.toCharArray()) {
                if (!dictionary.dictionaries.containsKey(symbol)) {
                    WordDictionary newDictionary = new WordDictionary();
                    newDictionary.key = symbol;
                    dictionary.dictionaries.put(symbol, newDictionary);
                }
                dictionary = dictionary.dictionaries.get(symbol);
            }

            dictionary.value = word;
        }

        @Override
        public boolean search(String word) {
            return word != null && persist(this, word, 0);
        }

        private static boolean persist(WordDictionary dictionary, String word, int index) {
            if (dictionary == null) return false;

            for (int i = index; i < word.length(); i++) {
                char symbol = word.charAt(i);
                if (symbol == '.') {
                    for (char key : dictionary.dictionaries.keySet()) {
                        boolean existence = persist(dictionary.dictionaries.get(key), word, i + 1);
                        if (existence) return true;
                    }
                    return false;
                } else {
                    if (!dictionary.dictionaries.containsKey(symbol)) return false;
                    dictionary = dictionary.dictionaries.get(symbol);
                }
            }

            return dictionary.value != null;
        }
    }

    public List<Boolean> process() {
        return WordDictionaryHandler.process(operations, new WordDictionary());
    }
}
