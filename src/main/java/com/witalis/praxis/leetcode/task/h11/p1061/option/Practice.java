package com.witalis.praxis.leetcode.task.h11.p1061.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1061
 * Name: Lexicographically Smallest Equivalent String
 * URL: <a href="https://leetcode.com/problems/lexicographically-smallest-equivalent-string/">Lexicographically Smallest Equivalent String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Practice {
    private String string1;
    private String string2;
    private String stringBase;

    public String process() {
        return smallestEquivalentString(string1, string2, stringBase);
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        final int LETTERS = 26;

        if (s1 == null || s2 == null || baseStr == null || baseStr.isEmpty()) return "";

        final Queue<Integer>[] groups = new Queue[LETTERS];
        final Comparator<Integer> lexicographical = Comparator.naturalOrder();

        final char[] chars1 = s1.toCharArray();
        final char[] chars2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            final int index1 = chars1[i] - 'a';
            final int index2 = chars2[i] - 'a';
            final Queue<Integer> group;
            if (groups[index1] == null && groups[index2] == null) {
                group = new PriorityQueue<>(lexicographical);
                groups[index1] = group;
                groups[index2] = group;
            } else if (groups[index1] != null && groups[index2] != null) {
                group = groups[index1];
                for (int index : groups[index2]) {
                    if (!group.contains(index)) {
                        group.offer(index);
                    }
                }
                for (int index : group) {
                    groups[index] = group;
                }
            } else {
                group = groups[index1] != null ? groups[index1] : groups[index2];
                if (groups[index1] == null) {
                    groups[index1] = group;
                } else {
                    groups[index2] = group;
                }
            }
            if (!group.contains(index1)) group.offer(index1);
            if (!group.contains(index2)) group.offer(index2);
        }

        final StringBuilder builder = new StringBuilder();
        final char[] charsBase = baseStr.toCharArray();
        for (char letter : charsBase) {
            int indexBase = letter - 'a';
            if (groups[indexBase] != null) indexBase = groups[indexBase].peek();
            builder.append((char) (indexBase + 'a'));
        }

        return builder.toString();
    }
}
