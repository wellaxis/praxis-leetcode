package com.witalis.praxis.leetcode.task.h23.p2272.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2272
 * Name: Substring With Largest Variance
 * URL: <a href="https://leetcode.com/problems/substring-with-largest-variance/">Substring With Largest Variance</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return largestVariance(string);
    }

    public int largestVariance(String s) {
        if (s == null || s.isEmpty()) return 0;

        int direct = helper(s);
        s = new StringBuilder(s).reverse().toString();
        int reverse = helper(s);

        return Math.max(direct, reverse);
    }

    private int helper(String s) {
        int variance = 0;

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (i != j) {
                    int count1 = 0;
                    int count2 = 0;
                    for (int k = 0; k < s.length(); k++) {
                        if (s.charAt(k) == i) {
                            count1++;
                        }
                        if (s.charAt(k) == j) {
                            count2++;
                        }
                        if (count2 > count1) {
                            count1 = 0;
                            count2 = 0;
                        }
                        if (count1 > 0 && count2 > 0) {
                            variance = Math.max(variance, count1 - count2);
                        }
                    }
                }
            }
        }

        return variance;
    }
}
