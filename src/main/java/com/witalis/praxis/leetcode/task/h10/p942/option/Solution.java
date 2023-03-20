package com.witalis.praxis.leetcode.task.h10.p942.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 942
 * Name: DI String Match
 * URL: <a href="https://leetcode.com/problems/di-string-match/">DI String Match</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public int[] process() {
        return diStringMatch(string);
    }

    public int[] diStringMatch(String s) {
        final int n = s.length();
        int[] ans = new int[n + 1];
        int min = 0;
        int max = n;

        for (int i = 0; i < n; ++i)
            ans[i] = s.charAt(i) == 'I' ? min++ : max--;
        ans[n] = min;

        return ans;
    }
}
