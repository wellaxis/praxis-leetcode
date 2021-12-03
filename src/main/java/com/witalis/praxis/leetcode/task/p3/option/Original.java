package com.witalis.praxis.leetcode.task.p3.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 3
 * Name: Longest Substring Without Repeating Characters
 * URL: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return lengthOfLongestSubstring(string);
    }

    public int lengthOfLongestSubstring(String s) {
        String max = "";
        if (!s.isEmpty()) {
            var chars = s.toCharArray();
            int index = 0;
            int position = 0;
            StringBuilder builder = new StringBuilder();
            do {
                char ch = s.charAt(position);

                if (!builder.toString().contains(String.valueOf(ch))) {
                    builder.append(ch);
                    position++;
                } else {
                    var current = builder.toString();
                    if (current.length() > max.length()) {
                        max = current;
                    }
                    builder = new StringBuilder();
                    index++;
                    position = index;
                }
            } while (index < chars.length && position < chars.length);
            var current = builder.toString();
            if (current.length() > max.length()) {
                max = current;
            }
        }
        return max.length();
    }
}
