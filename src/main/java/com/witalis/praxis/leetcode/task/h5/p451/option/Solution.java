package com.witalis.praxis.leetcode.task.h5.p451.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * ID: 451
 * Name: Sort Characters By Frequency
 * URL: <a href="https://leetcode.com/problems/sort-characters-by-frequency/">Sort Characters By Frequency</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return frequencySort(string);
    }

    public String frequencySort(String s) {
        int[] frequencies = new int[256];
        for (char ch : s.toCharArray()) frequencies[ch]++;

        TreeMap<Integer, List<Character>> tree = new TreeMap<>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                if (!tree.containsKey(frequencies[i])) {
                    tree.put(frequencies[i], new LinkedList<>());
                }
                tree.get(frequencies[i]).add((char) i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (tree.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            for (Character ch : entry.getValue()) {
                sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
            }
        }

        return sb.toString();
    }
}
