package com.witalis.praxis.leetcode.task.h2.p187.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 187
 * Name: Repeated DNA Sequences
 * URL: <a href="https://leetcode.com/problems/repeated-dna-sequences/">Repeated DNA Sequences</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String dna;

    public List<String> process() {
        return findRepeatedDnaSequences(dna);
    }

    // values: A, C, G, T could be converted to 2 bit integer: 0, 1, 2, 3
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();

        if (s == null || s.length() < 10) return result;

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('T', 2);
        map.put('G', 3);

        Set<Integer> appear = new HashSet<>();
        Set<Integer> added = new HashSet<>();

        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            tmp = (tmp << 2) + map.get(s.charAt(i));
            if (i >= 9) {
                tmp = tmp & ((1 << 20) - 1);
                if (appear.contains(tmp) && !added.contains(tmp)) {
                    added.add(tmp);
                    result.add(s.substring(i - 9, i + 1));
                } else {
                    appear.add(tmp);
                }
            }
        }

        return result;
    }
}
