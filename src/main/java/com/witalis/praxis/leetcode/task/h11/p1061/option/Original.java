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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string1;
    private String string2;
    private String stringBase;

    public String process() {
        return smallestEquivalentString(string1, string2, stringBase);
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        if (s1 == null || s2 == null || baseStr == null) return "";

        Map<Character, Queue<Character>> groups = new HashMap<>();
        Comparator<Character> lexicographical = Comparator.naturalOrder();

        int len = s1.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < len; i++) {
            char char1 = chars1[i];
            char char2 = chars2[i];
            Queue<Character> group;
            if (!groups.containsKey(char1) && !groups.containsKey(char2)) {
                group = new PriorityQueue<>(lexicographical);
                groups.put(char1, group);
                groups.put(char2, group);
            } else if (groups.containsKey(char1) && groups.containsKey(char2)) {
                group = groups.get(char1);
                for (Character character : groups.get(char2)) {
                    if (!group.contains(character)) {
                        group.offer(character);
                    }
                }
                group.forEach(character -> groups.put(character, group));
            } else {
                group = groups.containsKey(char1) ? groups.get(char1) : groups.get(char2);
                if (!groups.containsKey(char1)) groups.put(char1, group);
                if (!groups.containsKey(char2)) groups.put(char2, group);
            }
            if (!group.contains(char1)) group.offer(char1);
            if (!group.contains(char2)) group.offer(char2);
        }

        StringBuilder builder = new StringBuilder();
        char[] charsBase = baseStr.toCharArray();
        for (int i = 0; i < charsBase.length; i++) {
            char charBase = charsBase[i];
            if (groups.containsKey(charBase)) {
                builder.append(groups.get(charBase).peek());
            } else {
                builder.append(charBase);
            }
        }

        return builder.toString();
    }
}
