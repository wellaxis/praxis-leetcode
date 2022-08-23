package com.witalis.praxis.leetcode.task.h2.p192.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.witalis.praxis.leetcode.task.h2.p192.utils.WordUtils.THRESHOLD;
import static java.util.Map.Entry.comparingByKey;

/**
 * ID: 192
 * Name: Word Frequency
 * URL: <a href="https://leetcode.com/problems/word-frequency/">Word Frequency</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private File file;

    public String process() {
        calculateWordFrequency(file);
        return calculateWordFrequency();
    }

    public String calculateWordFrequency() {
        return "awk '{ for (i = 1; i <= NF; i++) { counts[$i]++ } } END { for (k in counts) { print(k, counts[k]) } }' words.txt | sort -nrk2 ";
    }

    public String calculateWordFrequency(File file) {
        if (file == null) return "";

        StringBuilder wordFrequency = new StringBuilder("\n");

        Map<String, Integer> frequency = new HashMap<>();
        try (Stream<String> stream = Files.lines(file.toPath())) {
            stream
                .filter(Predicate.not(String::isBlank))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(Predicate.not(String::isBlank))
                .forEach(
                    word -> frequency.put(word, frequency.getOrDefault(word, 0) + 1)
                );
        } catch (IOException ioe) {
            log.error("Calculate word frequency, IO error: {}", ioe.getMessage());
        }

        frequency.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(comparingByKey()))
            .filter(entry -> entry.getValue() >= THRESHOLD)
            .forEach(
                entry -> wordFrequency.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n")
            );

        return wordFrequency.substring(0, wordFrequency.length() - 1);
    }
}
