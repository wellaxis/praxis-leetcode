package com.witalis.praxis.leetcode.task.h2.p127.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 127
 * Name: Word Ladder
 * URL: <a href="https://leetcode.com/problems/word-ladder/">Word Ladder</a>
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

    public Integer process() {
        return ladderLength(beginWord, endWord, wordList);
    }

    record Pair(String word, int index) {}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) return 0;

        final Set<String> dictionary = new HashSet<>(wordList);

        if (!dictionary.contains(endWord)) return 0;

        final Deque<Pair> queue = new ArrayDeque<>();
        final Set<String> seen = new HashSet<>();

        queue.offer(new Pair(beginWord, 1));
        seen.add(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word();
            int index = pair.index();

            for (int i = 0; i < word.length(); i++) {
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    if (letter == word.charAt(i)) continue;

                    String transformation = word.substring(0, i) + letter + word.substring(i + 1);

                    if (dictionary.contains(transformation) && !seen.contains(transformation)) {
                        if (transformation.equals(endWord)) return index + 1;

                        queue.offer(new Pair(transformation, index + 1));
                        seen.add(transformation);
                    }
                }
            }
        }

        return 0;
    }
}
