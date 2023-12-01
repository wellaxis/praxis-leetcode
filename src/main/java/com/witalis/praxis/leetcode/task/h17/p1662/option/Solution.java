package com.witalis.praxis.leetcode.task.h17.p1662.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1662
 * Name: Check If Two String Arrays are Equivalent
 * URL: <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/">Check If Two String Arrays are Equivalent</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] word1;
    private String[] word2;

    public Boolean process() {
        return arrayStringsAreEqual(word1, word2);
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // pointers to mark the current word in the given two lists
        int word1Pointer = 0;
        int word2Pointer = 0;
        // pointers to mark the character in the string pointed by the above pointers
        int string1Pointer = 0;
        int string2Pointer = 0;

        // while we still have the string in any of the two given lists
        while (word1Pointer < word1.length && word2Pointer < word2.length) {
            // if the characters at the two string are same, increment the string pointers, otherwise return false
            if (word1[word1Pointer].charAt(string1Pointer++) != word2[word2Pointer].charAt(string2Pointer++)) {
                return false;
            }
            // if the string pointer reaches the end of string in the list word1,
            // move to the next string in the list and, reset the string pointer to 0
            if (string1Pointer == word1[word1Pointer].length()) {
                word1Pointer++;
                string1Pointer = 0;
            }
            // if the string pointer reaches the end of string in the list word2,
            // move to the next string in the list and, reset the string pointer to 0
            if (string2Pointer == word2[word2Pointer].length()) {
                word2Pointer++;
                string2Pointer = 0;
            }
        }

        // strings in both the lists should be traversed
        return word1Pointer == word1.length && word2Pointer == word2.length;
    }
}
