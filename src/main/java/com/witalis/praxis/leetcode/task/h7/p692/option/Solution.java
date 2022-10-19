package com.witalis.praxis.leetcode.task.h7.p692.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 692
 * Name: Top K Frequent Words
 * URL: <a href="https://leetcode.com/problems/top-k-frequent-words/">Top K Frequent Words</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;
    private int quantity;

    public List<String> process() {
        return topKFrequent(words, quantity);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        Queue<String> queue = new PriorityQueue<>(
            (word1, word2) -> Objects.equals(frequencies.get(word1), frequencies.get(word2))
                ? word1.compareTo(word2)
                : frequencies.get(word2) - frequencies.get(word1)
        );

        for (String word : words) frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        queue.addAll(frequencies.keySet());

        List<String> list = new LinkedList<>();
        while (k-- > 0) list.add(queue.poll());

        return list;
    }
}
