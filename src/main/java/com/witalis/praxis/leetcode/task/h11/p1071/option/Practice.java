package com.witalis.praxis.leetcode.task.h11.p1071.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1071
 * Name: Greatest Common Divisor of Strings
 * URL: <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">Greatest Common Divisor of Strings</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string1;
    private String string2;

    public String process() {
        return gcdOfStrings(string1, string2);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) return "";

        final int len1 = str1.length();
        final int len2 = str2.length();

        if (len2 > len1) return gcdOfStrings(str2, str1);
        if (!str1.startsWith(str2)) return "";

        String divisor;
        for (int i = len2; i > 0; i--) {
            divisor = str2.substring(0, i);
            if (len1 % i == 0 && len2 % i == 0 && str1.equals(divisor.repeat(len1 / i)) && str2.equals(divisor.repeat(len2 / i))) return divisor;
        }

        return "";
    }
}
