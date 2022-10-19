package com.witalis.praxis.leetcode.task.h7.p692.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * ID: 692
 * Name: Top K Frequent Words
 * URL: <a href="https://leetcode.com/problems/top-k-frequent-words/">Top K Frequent Words</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;
    private int quantity;

    public List<String> process() {
        return topKFrequent(words, quantity);
    }

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0 || k <= 0) return Collections.emptyList();

        return Arrays.stream(words)
            .filter(Objects::nonNull)
            .collect(groupingBy(Function.identity(), counting()))
            .entrySet().stream()
            .sorted(
                Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                    .thenComparing(Map.Entry::getKey))
            .map(Map.Entry::getKey)
            .limit(k)
            .toList();
    }
}
