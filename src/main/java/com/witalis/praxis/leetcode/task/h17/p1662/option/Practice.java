package com.witalis.praxis.leetcode.task.h17.p1662.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1662
 * Name: Check If Two String Arrays are Equivalent
 * URL: <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/">Check If Two String Arrays are Equivalent</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] word1;
    private String[] word2;

    public Boolean process() {
        return arrayStringsAreEqual(word1, word2);
    }

    static class Tokenizer {
        private final String[] word;
        private char[] letters;
        private int token;
        private int index;

        public Tokenizer(String[] word) {
            this.word = word;
            this.letters = word[0].toCharArray();
            this.token = 0;
            this.index = 0;
        }

        public char next() {
            if (index == letters.length) {
                index = 0;
                token++;
                if (token == word.length) {
                    return '.';
                } else {
                    letters = word[token].toCharArray();
                }
            }
            return letters[index++];
        }
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null) return false;

        final int n1 = word1.length;
        final int n2 = word2.length;

        if (n1 == 0 && n2 == 0) return true;
        if (n1 == 0 || n2 == 0) return false;

        final Tokenizer tokenizer1 = new Tokenizer(word1);
        final Tokenizer tokenizer2 = new Tokenizer(word2);

        char letter1;
        char letter2;
        do {
            letter1 = tokenizer1.next();
            letter2 = tokenizer2.next();

            if (letter1 != letter2) return false;
        } while (letter1 != '.');

        return true;
    }
}
