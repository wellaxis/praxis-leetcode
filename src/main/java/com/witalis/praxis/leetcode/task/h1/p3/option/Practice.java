package com.witalis.praxis.leetcode.task.h1.p3.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 3
 * Name: Longest Substring Without Repeating Characters
 * URL: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return lengthOfLongestSubstring(string);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        int[] chars = new int[128];
        var substring = "";

        int max = 0;
        int index = 0;
        int position = 0;

        while (index < s.length() && position < s.length()) {
            char ch = s.charAt(position);

            if (chars[ch] > 0) {
                if (position - index > max) {
                    max = position - index;
                    substring = s.substring(index, position);
                }
                char rem = s.charAt(index);
                chars[rem]--;
                index++;
            } else {
                chars[ch]++;
                position++;
            }
        }

        if (position - index > max) {
            max = position - index;
            substring = s.substring(index, position);
        }

        return max;
    }
}
