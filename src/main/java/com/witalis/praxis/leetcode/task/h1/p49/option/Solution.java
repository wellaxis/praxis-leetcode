package com.witalis.praxis.leetcode.task.h1.p49.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 49
 * Name: Group Anagrams
 * URL: <a href="https://leetcode.com/problems/powx-n/">Group Anagrams</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] strings;

    public List<List<String>> process() {
        return groupAnagrams(strings);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
