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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private List<String> wordDict;

    public Practice(String string, List<String> wordDict) {
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

        solver(s, wordDict, 0, new StringBuilder());

        return sentences;
    }

    private void solver(String s, List<String> words, int index, StringBuilder sentence) {
        if (index == s.length()) {
            sentences.add(sentence.substring(1));
        } else {
            for (String word : words)
                if (s.indexOf(word, index) == index) {
                    int length = sentence.length();
                    solver(s, words, index + word.length(), sentence.append(" ").append(word));
                    sentence.setLength(length);
                }
        }
    }
}
