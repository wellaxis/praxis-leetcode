package com.witalis.praxis.leetcode.task.h5.p472.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 472
 * Name: Concatenated Words
 * URL: <a href="https://leetcode.com/problems/concatenated-words/">Concatenated Words</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;

    public Original(String[] words) {
        this.words = words;
    }

    public List<String> process() {
        return findAllConcatenatedWordsInADict(words);
    }

    private Set<String> allWords;
    private Set<String> formedWords;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length == 0) return Collections.emptyList();

        allWords = new HashSet<>(Arrays.asList(words));
        formedWords = new HashSet<>();

        return allWords.stream().filter(this::isConcatenated).toList();
    }

    private boolean isConcatenated(String word) {
        if (formedWords.contains(word)) return true;

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (allWords.contains(prefix) && (allWords.contains(suffix) || isConcatenated(suffix))) {
                formedWords.add(word);
                return true;
            }
        }

        return false;
    }
}
