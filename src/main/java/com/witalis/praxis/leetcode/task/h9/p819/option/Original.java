package com.witalis.praxis.leetcode.task.h9.p819.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * ID: 819
 * Name: Most Common Word
 * URL: <a href="https://leetcode.com/problems/most-common-word/">Most Common Word</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String paragraph;
    private String[] banned;

    public String process() {
        return mostCommonWord(paragraph, banned);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || banned == null) return "";

        return Stream.of(paragraph)
            .map(s -> s.replaceAll("[!?',;.]", " "))
            .flatMap(Pattern.compile(" ")::splitAsStream)
            .filter(Predicate.not(String::isEmpty))
            .map(String::toLowerCase)
            .filter(s -> !Arrays.asList(banned).contains(s))
            .collect(groupingBy(Function.identity(), counting()))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("");
    }
}
