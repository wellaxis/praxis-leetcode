package com.witalis.praxis.leetcode.task.h24.p2306.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ID: 2306
 * Name: Naming a Company
 * URL: <a href="https://leetcode.com/problems/naming-a-company/">Naming a Company</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] ideas;

    public Long process() {
        return distinctNames(ideas);
    }

    public long distinctNames(String[] ideas) {
        if (ideas == null) return 0;

        Map<Character, Set<String>> dictionary = new HashMap<>();
        for (String idea : ideas) {
            dictionary.putIfAbsent(idea.charAt(0), new HashSet<>());
            dictionary.get(idea.charAt(0)).add(idea.substring(1));
        }

        int count = 0;
        int len = ideas.length;
        String idea1;
        String idea2;
        char prefix1;
        char prefix2;
        String suffix1;
        String suffix2;
        for (int i = 0; i < len; i++) {
            idea1 = ideas[i];
            prefix1 = idea1.charAt(0);
            suffix1 = idea1.substring(1);
            for (int j = i + 1; j < len; j++) {
                idea2 = ideas[j];
                prefix2 = idea2.charAt(0);
                suffix2 = idea2.substring(1);

                if (prefix1 == prefix2) continue;
                if (suffix1.equals(suffix2)) continue;
                if (dictionary.get(prefix1).contains(suffix2)) continue;
                if (dictionary.get(prefix2).contains(suffix1)) continue;
                count += 2;
            }
        }

        return count;
    }
}
