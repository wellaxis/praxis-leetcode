package com.witalis.praxis.leetcode.task.h1.p28.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 28
 * Name: Implement strStr()
 * URL: <a href="https://leetcode.com/problems/implement-strstr/">Implement strStr()</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String haystack;
    private String needle;

    public Integer process() {
        return strStr(haystack, needle);
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null) return 0;
        if (needle == null || needle.isEmpty()) return 0;

        int index = 0;
        while (index <= haystack.length() - needle.length()) {
            char ch = haystack.charAt(index);
            // haystack.startsWith(needle, index))
            if (ch == needle.charAt(0) && haystack.substring(index, index + needle.length()).equals(needle))
                return index;
            index++;
        }

        return -1;
    }
}
