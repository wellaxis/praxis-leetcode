package com.witalis.praxis.leetcode.task.h5.p433.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 433
 * Name: Minimum Genetic Mutation
 * URL: <a href="https://leetcode.com/problems/minimum-genetic-mutation/">Minimum Genetic Mutation</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String start;
    private String end;
    private String[] bank;

    public Integer process() {
        return minMutation(start, end, bank);
    }

    public class GeneTrie {
        private GeneTrie.TrieNode root;

        public class TrieNode {
            private char nucleotideType;
            private String gene;
            private Map<Character, GeneTrie.TrieNode> children;

            public TrieNode() {
                this.children = new HashMap<>();
            }

            public TrieNode(char nucleotideType) {
                this();
                this.nucleotideType = nucleotideType;
            }
        }

        public GeneTrie() {
            this.root = new GeneTrie.TrieNode();
        }

        public void insert(String gene) {
            if (gene == null) return;

            GeneTrie.TrieNode node = root;
            for (char letter : gene.toCharArray()) {
                if (!node.children.containsKey(letter)) {
                    GeneTrie.TrieNode subNode = new GeneTrie.TrieNode(letter);
                    node.children.put(letter, subNode);
                }
                node = node.children.get(letter);
            }

            node.gene = gene;
        }

        public GeneTrie.TrieNode search(String gene) {
            if (gene == null) return null;

            GeneTrie.TrieNode node = root;
            for (char letter : gene.toCharArray()) {
                if (!node.children.containsKey(letter)) return null;
                node = node.children.get(letter);
            }

            return node;
        }

        public boolean contains(String gene) {
            if (gene == null) return false;

            GeneTrie.TrieNode node = search(gene);
            return node != null && node.gene != null;
        }

        public void delete(String gene) {
            GeneTrie.TrieNode node = search(gene);
            if (node != null) node.gene = null;
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() < 8 || end.length() < 8) return -1;
        if (start.length() != end.length()) return -1;
        if (start.equals(end)) return 0;

        int mutations = 0;
        char[] nucleotideTypes = {'A','C','G','T'};

        GeneTrie trie = new GeneTrie();
        Arrays.stream(bank).forEach(trie::insert);

        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);

        while (true) {
            mutations++;

            if (queue.isEmpty()) return -1;

            int size = queue.size();
            for (int gene = 0; gene < size; gene++) {
                char[] letters = Objects.requireNonNull(queue.poll()).toCharArray();

                for (int position = 0; position < 8; position++) {
                    char letter = letters[position];

                    for (int type = 0; type < 4; type++) {
                        letters[position] = nucleotideTypes[type];
                        String modifiedGene = String.valueOf(letters);
                        if (end.equals(modifiedGene) && trie.contains(modifiedGene)) {
                            return mutations;
                        } else if (!trie.contains(modifiedGene)) {
                            continue;
                        }
                        trie.delete(modifiedGene);
                        queue.add(modifiedGene);
                    }

                    letters[position] = letter;
                }
            }
        }
    }
}
