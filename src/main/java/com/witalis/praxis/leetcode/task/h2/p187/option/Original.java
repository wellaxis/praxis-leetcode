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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String dna;

    public List<String> process() {
        return findRepeatedDnaSequences(dna);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        final int LEN = 10;

        if (s == null || s.length() < LEN) return Collections.emptyList();

        List<String> sequences = new ArrayList<>();
        Map<String, Integer> sections = new HashMap<>();

        for (int i = 0; i <= s.length() - LEN; i++) {
            String section = s.substring(i, i + 10);
            if (sections.containsKey(section)) {
                sections.computeIfPresent(section, (sequence, frequency) -> ++frequency);
            } else {
                sections.putIfAbsent(section, 1);
            }
        }

        sections.forEach(
            (key, value) -> {
                if (value > 1) sequences.add(key);
            }
        );

        return sequences;
    }
}
