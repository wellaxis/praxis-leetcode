package com.witalis.praxis.leetcode.task.h4.p345.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 345
 * Name: Reverse Vowels of a String
 * URL: <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">Reverse Vowels of a String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return reverseVowels(string);
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] str1 = s.toCharArray();
        while (i < j) {
            if (!isVowel(str1[i])) {
                i++;
                continue;
            }
            if (!isVowel(str1[j])) {
                j--;
                continue;
            }

            // swapping
            char t = str1[i];
            str1[i]= str1[j];
            str1[j]= t;

            i++;
            j--;
        }

        return String.copyValueOf(str1);
    }

    public static boolean isVowel(char c) {
        return (
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
            c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        );
    }
}
