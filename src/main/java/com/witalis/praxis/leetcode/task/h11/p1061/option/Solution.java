package com.witalis.praxis.leetcode.task.h11.p1061.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1061
 * Name: Lexicographically Smallest Equivalent String
 * URL: <a href="https://leetcode.com/problems/lexicographically-smallest-equivalent-string/">Lexicographically Smallest Equivalent String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string1;
    private String string2;
    private String stringBase;

    public String process() {
        return smallestEquivalentString(string1, string2, stringBase);
    }

    class DisjointSetUnion {
        public static final int LETTERS = 26;
        private final int[] representative;

        public DisjointSetUnion() {
            this.representative = new int[LETTERS];
            // make each character representative of itself
            for (int i = 0; i < 26; i++) {
                representative[i] = i;
            }
        }

        public int find(int x) {
            if (representative[x] == x) {
                return x;
            }
            representative[x] = find(representative[x]);

            return representative[x];
        }

        public void performUnion(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) {
                return;
            }

            // make the smaller character representative.
            if (x < y) {
                representative[y] = x;
            } else {
                representative[x] = y;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSetUnion dsu = new DisjointSetUnion();

        // perform union merge for all the edges
        for (int i = 0; i < s1.length(); i++) {
            dsu.performUnion(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // create the answer string with final mappings
        StringBuilder ans = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            ans.append((char) (dsu.find(c - 'a') + 'a'));
        }

        return ans.toString();
    }
}
