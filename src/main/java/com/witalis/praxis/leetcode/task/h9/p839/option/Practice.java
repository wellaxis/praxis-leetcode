package com.witalis.praxis.leetcode.task.h9.p839.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 839
 * Name: Similar String Groups
 * URL: <a href="https://leetcode.com/problems/similar-string-groups/">Similar String Groups</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] strings;

    public Practice(String[] strings) {
        this.strings = strings;
    }

    public Integer process() {
        return numSimilarGroups(strings);
    }

    private boolean[] seen;

    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length == 0) return 0;

        final int n = strs.length;
        this.seen = new boolean[n];

        int groups = 0;
        for (int i = 0; i < n; i++)
            if (!seen[i]) {
                dfs(strs, i);
                groups++;
            }

        return groups;
    }

    private void dfs(String[] strs, int index) {
        if (seen[index]) return;

        seen[index] = true;
        for (int i = 0; i < strs.length; i++)
            if (!seen[i] && isSimilar(strs[index], strs[i]))
                dfs(strs, i);
    }

    private boolean isSimilar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i) && (++count > 2))
                return false;

        return count == 2 || count == 0;
    }
}
