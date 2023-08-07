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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String beginWord;
    private String endWord;
    private List<String> wordList;

    public List<List<String>> process() {
        return findLadders(beginWord, endWord, wordList);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) return Collections.emptyList();

        List<List<String>> ladders = new ArrayList<>();

        Map<String, List<String>> graph = new HashMap<>();
        for (String words : wordList) {
            graph.put(words, new ArrayList<>());
        }
        if (!graph.containsKey(beginWord)) {
            wordList.add(beginWord);
            graph.put(beginWord, new ArrayList<>());
        }

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    String candidate = word.substring(0, i) + ch + word.substring(i + 1);
                    if (graph.containsKey(candidate) && !word.equals(candidate)) {
                        List<String> list = graph.get(word);
                        list.add(candidate);
                        graph.put(word, list);
                    }
                }
            }
        }

        Set<String> seen = new HashSet<>(wordList.size());
        Map<String, Integer> distances = new HashMap<>();

        int length = bfs(beginWord, endWord, graph, seen, distances);
        if (length == 0) return ladders;

        dfs(endWord, beginWord, graph, distances, ladders, new ArrayList<>());

        return ladders;
    }

    public int bfs(String source, String target, Map<String, List<String>> graph, Set<String> seen, Map<String, Integer> distances) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        seen.add(source);

        int level = 0;
        distances.put(source, level);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String candidate = queue.remove();
                if (candidate.equals(target)) return level;

                for (String neighbour : graph.get(candidate)) {
                    if (!seen.contains(neighbour)) {
                        seen.add(neighbour);
                        queue.add(neighbour);
                        distances.put(neighbour, distances.get(candidate) + 1);
                    }
                }
            }

            level++;
        }

        return 0;
    }

    public void dfs(String source, String target, Map<String, List<String>> graph, Map<String, Integer> distances, List<List<String>> ladders, List<String> path) {
        if (source.equals(target)) {
            path.add(target);
            List<String> list = new ArrayList<>(path);
            Collections.reverse(list);

            ladders.add(list);
            path.remove(path.size() - 1);
            return;
        }

        path.add(source);

        for (String neighbour : graph.get(source)) {
            if (distances.containsKey(neighbour) && distances.get(neighbour) + 1 == distances.get(source)) {
                dfs(neighbour, target, graph, distances, ladders, path);
            }
        }

        path.remove(path.size() - 1);
    }
}
