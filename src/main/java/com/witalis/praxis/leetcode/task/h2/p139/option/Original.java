package com.witalis.praxis.leetcode.task.h2.p139.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ID: 139
 * Name: Word Break
 * URL: <a href="https://leetcode.com/problems/word-break/">Word Break</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private List<String> wordDict;

    public Boolean process() {
        return wordBreak(string, wordDict);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) return false;

        return recursiveBreak(s, wordDict, 0, new Boolean[s.length()]);
    }

    private static boolean recursiveBreak(String s, List<String> words, int index, Boolean[] segmentations) {
        if (index == s.length()) return true;
        if (segmentations[index] != null) return segmentations[index];

        for (String word : words) {
            if (s.indexOf(word, index) == index && recursiveBreak(s, words, index + word.length(), segmentations)) {
                segmentations[index] = true;
                return true;
            }
        }

        segmentations[index] = false;
        return false;
    }
}
