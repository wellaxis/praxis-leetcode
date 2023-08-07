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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String beginWord;
    private String endWord;
    private List<String> wordList;

    public Practice(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        this.wordList = wordList;
    }

    public List<List<String>> process() {
        return findLadders(beginWord, endWord, wordList);
    }

    private List<List<String>> ladders;
    private Map<String, List<String>> graph;
    private Map<String, Integer> distances;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) return Collections.emptyList();

        this.ladders = new ArrayList<>();

        if (!wordList.contains(endWord)) return ladders;

        if (!wordList.contains(beginWord))
            wordList.add(beginWord);

        this.graph = new HashMap<>();
        for (String word : wordList)
            graph.put(word, new ArrayList<>());

        for (String word : wordList)
            for (int i = 0; i < word.length(); i++)
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    String candidate = word.substring(0, i) + ch + word.substring(i + 1);
                    if (graph.containsKey(candidate) && !word.equals(candidate))
                        graph.get(word).add(candidate);
                }

        this.distances = new HashMap<>();

        int length = bfs(beginWord, endWord, new HashSet<>(wordList.size()));

        if (length == 0) return ladders;

        dfs(endWord, beginWord, new ArrayList<>());

        return ladders;
    }

    public int bfs(String source, String target, Set<String> seen) {
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

    public void dfs(String source, String target, List<String> path) {
        if (source.equals(target)) {
            path.add(target);
            List<String> list = new ArrayList<>(path);
            Collections.reverse(list);

            ladders.add(list);
        } else {
            path.add(source);

            for (String neighbour : graph.get(source))
                if (distances.containsKey(neighbour) && distances.get(neighbour) + 1 == distances.get(source))
                    dfs(neighbour, target, path);
        }
        path.remove(path.size() - 1);
    }
}
