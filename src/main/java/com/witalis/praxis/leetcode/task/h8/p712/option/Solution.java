package com.witalis.praxis.leetcode.task.h8.p712.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 712
 * Name: Minimum ASCII Delete Sum for Two Strings
 * URL: <a href="https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/">Minimum ASCII Delete Sum for Two Strings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string1;
    private String string2;

    public Integer process() {
        return minimumDeleteSum(string1, string2);
    }

    public int minimumDeleteSum(String s1, String s2) {
        // make sure s2 is smaller string
        if (s1.length() < s2.length()) {
            return minimumDeleteSum(s2, s1);
        }

        // case for empty s1
        int m = s1.length();
        int n = s2.length();
        int[] currRow = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            currRow[j] = currRow[j - 1] + s2.charAt(j - 1);
        }

        // compute answer row-by-row
        for (int i = 1; i <= m; i++) {
            int diag = currRow[0];
            currRow[0] += s1.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                int answer;

                // if characters are the same, the answer is top-left-diagonal value
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    answer = diag;
                } else {
                    // otherwise, the answer is minimum of top and left values with deleted character's ASCII value
                    answer = Math.min(
                        s1.charAt(i - 1) + currRow[j],
                        s2.charAt(j - 1) + currRow[j - 1]
                    );
                }

                // before overwriting currRow[j] with answer, save it in diag for the next column
                diag = currRow[j];
                currRow[j] = answer;
            }
        }

        // return the answer
        return currRow[n];
    }
}
