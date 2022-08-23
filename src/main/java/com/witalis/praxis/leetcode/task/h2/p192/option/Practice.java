package com.witalis.praxis.leetcode.task.h2.p192.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

import static com.witalis.praxis.leetcode.task.h2.p192.utils.WordUtils.THRESHOLD;

/**
 * ID: 192
 * Name: Word Frequency
 * URL: <a href="https://leetcode.com/problems/word-frequency/">Word Frequency</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private File file;

    public String process() {
        calculateWordFrequency(file);
        return calculateWordFrequency();
    }

    public String calculateWordFrequency() {
        return "grep -Eio \"\\w+\" words.txt | sort | uniq -c | sort -nr | awk '{print $2, $1}'";
    }

    public String calculateWordFrequency(File file) {
        if (file == null) return "";

        StringBuilder wordFrequency = new StringBuilder("\n");

        Map<String, Integer> frequency = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            lines.forEach(
                line -> {
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (!word.isBlank()) frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                    }
                }
            );
        } catch (IOException ioe) {
            log.error("Calculate word frequency, IO error: {}", ioe.getMessage());
        }

        List<Map.Entry<String, Integer>> data = new LinkedList<>(frequency.entrySet());
        data.sort(
            Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                .thenComparing(Map.Entry.comparingByKey())
        );
        data.forEach(
            item -> {
                if (item.getValue() < THRESHOLD) return;
                wordFrequency.append(item.getKey()).append(" ").append(item.getValue()).append("\n");
            }
        );

        return wordFrequency.substring(0, wordFrequency.length() - 1);
    }
}
