package com.witalis.praxis.leetcode.task.h2.p127.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ID: 127
 * Name: Word Ladder
 * URL: <a href="https://leetcode.com/problems/word-ladder/">Word Ladder</a>
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

    public Integer process() {
        return ladderLength(beginWord, endWord, wordList);
    }

    record Pair(String word, int index) {}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) return 0;

        Set<String> dictionary = new HashSet<>(wordList);

        if (!dictionary.contains(endWord)) return 0;

        Set<Character> letters = new HashSet<>();
        for (char letter = 'a'; letter <= 'z'; letter++) letters.add(letter);

        Deque<Pair> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();

        queue.offer(new Pair(beginWord, 1));
        seen.add(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < pair.word().length(); i++) {
                for (char letter : letters) {
                    if (letter == pair.word().charAt(i)) continue;

                    String transformation = pair.word().substring(0, i) + letter + pair.word().substring(i + 1);

                    if (dictionary.contains(transformation) && !seen.contains(transformation)) {
                        if (transformation.equals(endWord)) return pair.index() + 1;

                        queue.offer(new Pair(transformation, pair.index() + 1));
                        seen.add(transformation);
                    }
                }
            }
        }

        return 0;
    }
}
