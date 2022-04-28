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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String dna;

    public List<String> process() {
        return findRepeatedDnaSequences(dna);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        final int LEN = 10;

        if (s == null || s.length() < LEN) return Collections.emptyList();

        Set<String> sequences = new HashSet<>();
        Set<String> sections = new HashSet<>();

        for (int i = 0; i <= s.length() - LEN; i++) {
            String section = s.substring(i, i + 10);
            if (sections.contains(section)) {
                sequences.add(section);
            } else {
                sections.add(section);
            }
        }

        return List.copyOf(sequences);
    }
}
