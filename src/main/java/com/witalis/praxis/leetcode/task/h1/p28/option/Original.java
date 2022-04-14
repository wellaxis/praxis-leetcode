package com.witalis.praxis.leetcode.task.h1.p28.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 28
 * Name: Implement strStr()
 * URL: <a href="https://leetcode.com/problems/implement-strstr/">Implement strStr()</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
            if (ch == needle.charAt(0)) {
                int counter = 0;
                boolean check = true;
                while (counter < needle.length()) {
                    ch = haystack.charAt(index);
                    char need = needle.charAt(counter);
                    if (ch == need) {
                        index++;
                    } else {
                        check = false;
                        index -= counter;
                        break;
                    }
                    counter++;
                }
                if (check) return index - needle.length();
            }
            index++;
        }

        return -1;
    }
}
