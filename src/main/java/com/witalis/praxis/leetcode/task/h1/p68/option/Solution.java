package com.witalis.praxis.leetcode.task.h1.p68.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 68
 * Name: Text Justification
 * URL: <a href="https://leetcode.com/problems/text-justification/">Text Justification</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;
    private int maxWidth;

    public List<String> process() {
        return fullJustify(words, maxWidth);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0) return result;

        int begin = 0;
        int end = 0;
        while (begin < words.length) {
            // determine end such that words[begin...end-1] fit in a line and words[begin...end] do not.
            int currentLength = words[begin].length();
            for (end = begin + 1; end < words.length; end++) {
                if (currentLength + words[end].length() + 1 <= maxWidth) {
                    currentLength += words[end].length() + 1;
                } else {
                    break;
                }
            }

            // construct a justified line with words[begin...end-1]
            StringBuilder temp = new StringBuilder();
            temp.append(words[begin]);
            // last line or a line with only one word
            if (end == words.length || end == begin + 1) {
                // left justified
                for (int i = begin + 1; i < end; i++) {
                    temp.append(' ');
                    temp.append(words[i]);
                }
                for (int i = 0; i < maxWidth - currentLength; i++) temp.append(' ');
            } else {
                // fully justified
                int spaceInBetween = end - begin - 1;
                double spaces = maxWidth - currentLength + spaceInBetween;
                for (int i = begin + 1; i < end; i++) {
                    for (int j = 0; j < spaces / spaceInBetween; j++) {
                        temp.append(' ');
                    }
                    spaces -= Math.ceil(spaces / spaceInBetween);
                    spaceInBetween--;
                    temp.append(words[i]);
                }
            }

            // add the line to the resulting list, and slide the window to the next position
            result.add(temp.toString());
            begin = end;
        }

        return result;
    }
}
