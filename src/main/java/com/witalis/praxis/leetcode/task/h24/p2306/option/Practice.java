package com.witalis.praxis.leetcode.task.h24.p2306.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2306
 * Name: Naming a Company
 * URL: <a href="https://leetcode.com/problems/naming-a-company/">Naming a Company</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] ideas;

    public Long process() {
        return distinctNames(ideas);
    }

    public long distinctNames(String[] ideas) {
        if (ideas == null) return 0;

        final Map<Character, Set<String>> dictionary = new HashMap<>();
        for (final String idea : ideas) {
            dictionary.putIfAbsent(idea.charAt(0), new HashSet<>());
            dictionary.get(idea.charAt(0)).add(idea.substring(1));
        }

        final Character[] prefixes = dictionary.keySet().toArray(Character[]::new);
        Arrays.sort(prefixes);

        long count = 0;
        Set<String> suffixes1;
        Set<String> suffixes2;
        final int len = prefixes.length;
        for (int i = 0; i < len; i++) {
            suffixes1 = dictionary.get(prefixes[i]);

            for (int j = i + 1; j < len; j++) {
                suffixes2 = dictionary.get(prefixes[j]);

                int similarities = 0;
                for (String suffix : suffixes1) {
                    if (suffixes2.contains(suffix)) similarities++;
                }

                count += 2L * (suffixes1.size() - similarities) * (suffixes2.size() - similarities);
            }
        }

        return count;
    }
}
