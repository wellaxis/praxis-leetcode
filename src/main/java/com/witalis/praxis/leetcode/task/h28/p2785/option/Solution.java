package com.witalis.praxis.leetcode.task.h28.p2785.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2785
 * Name: Sort Vowels in a String
 * URL: <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">Sort Vowels in a String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return sortVowels(string);
    }

    public String sortVowels(String s) {
        int[] count = new int[1000];

        // store the frequencies for each character
        for (char c : s.toCharArray())
            if (isVowel(c))
                count[c - 'A']++;

        // sorted string having all the vowels
        String sortedVowel = "AEIOUaeiou";
        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!isVowel(s.charAt(i))) {
                ans.append(s.charAt(i));
            } else {
                // skip to the character which is having remaining count
                while (count[sortedVowel.charAt(j) - 'A'] == 0) {
                    j++;
                }

                ans.append(sortedVowel.charAt(j));
                count[sortedVowel.charAt(j) - 'A']--;
            }
        }

        return ans.toString();
    }

    private static boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
            || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }
}
