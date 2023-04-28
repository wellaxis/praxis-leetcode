package com.witalis.praxis.leetcode.task.h9.p839.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 839
 * Name: Similar String Groups
 * URL: <a href="https://leetcode.com/problems/similar-string-groups/">Similar String Groups</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] strings;

    public Integer process() {
        return numSimilarGroups(strings);
    }

    static class UnionFind {
        int[] ids;
        int[] levels;
        int solid;

        UnionFind(int n) {
            solid = n;
            ids = new int[n];
            for (int i = 0; i < n; ++i)
                ids[i] = i;
            levels = new int[n];
        }

        public void connect(int i, int j) {
            i = getParent(i);
            j = getParent(j);
            if (i == j)
                return;
            if (levels[i] >= levels[j]) {
                ids[j] = ids[i];
                ++levels[i];
            } else {
                ids[i] = ids[j];
                ++levels[j];
            }
            --solid;
        }

        public int getSolid() {
            return solid;
        }

        public int getParent(int n) {
            while (n != ids[n]) {
                ids[n] = ids[ids[n]];
                n = ids[n];
            }
            return n;
        }
    }

    public int numSimilarGroups(String[] strs) {
        if (strs.length <= 1) return strs.length;

        char[][] strsArrays = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; ++i) {
            strsArrays[i] = strs[i].toCharArray();
        }

        UnionFind unionFind = new UnionFind(strs.length);
        for (int i = 0; i < strsArrays.length; ++i) {
            for (int j = i + 1; j < strsArrays.length; ++j) {
                if (isConnect(strsArrays[i], strsArrays[j])) {
                    unionFind.connect(i, j);
                }
            }
        }

        return unionFind.getSolid();
    }

    public boolean isConnect(char[] a, char[] b) {
        int p = -1, q = -1, count = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != b[i]) {
                if (++count > 2)
                    return false;
                if (p < 0)
                    p = i;
                else if (q < 0)
                    q = i;
            }
        }
        return count == 0 || p >= 0 && q >= 0 && a[p] == b[q] && a[q] == b[p];
    }
}
