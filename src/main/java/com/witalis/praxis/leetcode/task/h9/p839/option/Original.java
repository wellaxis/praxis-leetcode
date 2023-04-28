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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] strings;

    public Integer process() {
        return numSimilarGroups(strings);
    }

    public int numSimilarGroups(String[] strs) {
        if (strs == null || strs.length == 0) return 0;

        int groups = 0;

        final Set<String> seen = new HashSet<>();
        for (String string : strs) {
            if (!seen.contains(string)) {
                dfs(strs, string, seen);
                groups++;
            }
        }

        return groups;
    }

    private void dfs(String[] strs, String str, Set<String> seen) {
        if (seen.contains(str)) return;

        seen.add(str);
        for (String s : strs) {
            if (isSimilar(str, s)) {
                dfs(strs, s, seen);
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count > 2) return false;
            }
        }

        return count == 2 || count == 0;
    }
}
