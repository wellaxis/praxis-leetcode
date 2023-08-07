package com.witalis.praxis.leetcode.task.h2.p126.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 126
 * Name: Word Ladder II
 * URL: <a href="https://leetcode.com/problems/word-ladder-ii/">Word Ladder II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String beginWord;
    private String endWord;
    private List<String> wordList;

    public List<List<String>> process() {
        return findLadders(beginWord, endWord, wordList);
    }

    public static class Node {
        private String word;
        private List<Node> parents;

        public Node(String word, List<Node> parents) {
            this.word = word;
            this.parents = parents;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, new ArrayList<>()));
        words.remove(beginWord);
        boolean found = false;
        Node endNode = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<String, Node> levelWords = new HashMap<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                char[] chars = node.word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char t = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == t) {
                            continue;
                        }
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if (!words.contains(nextWord)) {
                            continue;
                        }

                        if (endWord.equals(nextWord)) {
                            found = true;
                        }

                        if (levelWords.containsKey(nextWord)) {
                            levelWords.get(nextWord).parents.add(node);
                        } else {
                            List<Node> parents = new ArrayList<>();
                            parents.add(node);

                            Node nextNode = new Node(nextWord, parents);
                            if (found && nextWord.equals(endWord)) {
                                endNode = nextNode;
                            }

                            levelWords.put(nextWord, nextNode);
                        }
                    }
                    chars[j] = t;
                }
            }

            if (found) {
                break;
            }

            for (String wd : levelWords.keySet()) {
                words.remove(wd);
                queue.add(levelWords.get(wd));
            }

        }

        if (!found) {
            return res;
        }

        findPath(endNode, res, new ArrayList<>());

        return res;
    }

    private void findPath(Node node, List<List<String>> res, List<String> path) {
        path.add(node.word);

        if (node.parents.isEmpty()) {
            List<String> reverse = new ArrayList<>();
            for (int i = path.size() - 1; i >= 0; i--) {
                reverse.add(path.get(i));
            }
            res.add(reverse);
            return;
        }

        for (Node parent : node.parents) {
            List<String> newPath = new ArrayList<>(path);
            findPath(parent, res, newPath);
        }
    }
}
