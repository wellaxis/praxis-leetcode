package com.witalis.praxis.leetcode.task.h1.p49.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 49
 * Name: Group Anagrams
 * URL: https://leetcode.com/problems/powx-n/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] strings;

    public List<List<String>> process() {
        return groupAnagrams(strings);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return Collections.emptyList();

        Map<String, List<String>> groups = new HashMap<>();

        for (String string: strs) {
            var chars = string.toCharArray();
            Arrays.sort(chars);
            var key = String.valueOf(chars);
            if (groups.containsKey(key)) {
                List<String> group = groups.get(key);
                group.add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                groups.put(key, group);
            }
        }

        return new ArrayList<>(groups.values());
    }
}
