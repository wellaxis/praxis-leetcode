package com.witalis.praxis.leetcode.task.h11.p1071.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1071
 * Name: Greatest Common Divisor of Strings
 * URL: <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">Greatest Common Divisor of Strings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string1;
    private String string2;

    public String process() {
        return gcdOfStrings(string1, string2);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) return "";

        int len1 = str1.length();
        int len2 = str2.length();

        int len = Math.min(len1, len2);
        String str;
        if (len == len1) {
            str = str1;
            if (!str2.startsWith(str1)) return "";
        } else {
            str = str2;
            if (!str1.startsWith(str2)) return "";
        }

        String prefix;
        for (int i = len; i > 0; i--) {
            prefix = str.substring(0, i);
            if (len1 % i == 0 && len2 % i == 0) {
                int count1 = len1 / i;
                int count2 = len2 / i;
                if (str1.equals(prefix.repeat(count1)) && str2.equals(prefix.repeat(count2))) return prefix;
            }
        }

        return "";
    }
}
