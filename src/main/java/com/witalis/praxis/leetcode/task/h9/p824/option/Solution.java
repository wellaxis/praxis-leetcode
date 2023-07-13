package com.witalis.praxis.leetcode.task.h9.p824.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 824
 * Name: Goat Latin
 * URL: <a href="https://leetcode.com/problems/goat-latin/">Goat Latin</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String sentence;

    public String process() {
        return toGoatLatin(sentence);
    }

    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        int r = 1;
        for (String word : words) {
            char ch = word.charAt(0);
            if ("AEIOUaeiou".indexOf(ch) != -1)
                sb.append(word).append("ma").append("a".repeat(r++)).append(" ");
            else
                sb.append(word.substring(1)).append(word.charAt(0)).append("ma").append("a".repeat(r++)).append(" ");
        }

        return sb.toString().trim();
    }
}
