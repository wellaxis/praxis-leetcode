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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public class Trie implements ITrie {
        private char key;
        private String value;
        private Map<Character, Trie> tries;

        public Trie() {
            this.tries = new HashMap<>();
        }

        @Override
        public void insert(String word) {
            if (word == null) return;

            Trie trie = this;
            for (char symbol : word.toCharArray()) {
                if (!trie.tries.containsKey(symbol)) {
                    Trie newTrie = new Trie();
                    newTrie.key = symbol;
                    trie.tries.put(symbol, newTrie);
                }
                trie = trie.tries.get(symbol);
            }

            trie.value = word;
        }

        @Override
        public boolean search(String word) {
            if (word == null) return false;

            Trie trie = this;
            for (char symbol : word.toCharArray()) {
                if (!trie.tries.containsKey(symbol)) return false;
                trie = trie.tries.get(symbol);
            }

            return trie.value != null;
        }

        @Override
        public boolean startsWith(String prefix) {
            if (prefix == null) return false;

            Trie trie = this;
            for (char symbol : prefix.toCharArray()) {
                if (!trie.tries.containsKey(symbol)) return false;
                trie = trie.tries.get(symbol);
            }

            return trie != null;
        }
    }

    public List<Boolean> process() {
        return TrieHandler.process(operations, new Trie());
    }
}
