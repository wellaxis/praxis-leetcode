package com.witalis.praxis.leetcode.task.h2.p140.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 140
 * Name: Word Break II
 * URL: <a href="https://leetcode.com/problems/word-break-ii/">Word Break II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private List<String> wordDict;

    public Original(String string, List<String> wordDict) {
        this.string = string;
        this.wordDict = wordDict;
    }

    public List<String> process() {
        return wordBreak(string, wordDict);
    }

    private List<String> sentences;

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) return Collections.emptyList();

        this.sentences = new ArrayList<>();

        solver(s, wordDict, 0, new ArrayList<>());

        return sentences;
    }

    private void solver(String s, List<String> words, int index, List<String> sentence) {
        if (index == s.length()) {
            StringBuilder builder = new StringBuilder();
            for (String word : sentence)
                builder.append(word).append(" ");
            builder.deleteCharAt(builder.length() - 1);
            sentences.add(builder.toString());
            return;
        }

        for (String word : words) {
            if (s.indexOf(word, index) == index) {
                List<String> candidate = new ArrayList<>(sentence);
                candidate.add(word);
                solver(s, words, index + word.length(), candidate);
                candidate.remove(word);
            }
        }
    }
}
