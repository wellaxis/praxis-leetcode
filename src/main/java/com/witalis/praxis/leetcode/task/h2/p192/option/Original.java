package com.witalis.praxis.leetcode.task.h2.p192.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.witalis.praxis.leetcode.task.h2.p192.utils.WordUtils.THRESHOLD;

/**
 * ID: 192
 * Name: Word Frequency
 * URL: <a href="https://leetcode.com/problems/word-frequency/">Word Frequency</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private File file;

    public String process() {
        calculateWordFrequency(file);
        return calculateWordFrequency();
    }

    public String calculateWordFrequency() {
        return "cat words.txt | tr -s ' ' '\\n' | sort | uniq -c | sort -nr | awk '{ print $2, $1 }'";
    }

    public String calculateWordFrequency(File file) {
        if (file == null) return "";

        StringBuilder wordFrequency = new StringBuilder("\n");

        Map<String, Integer> frequency = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file, Charset.defaultCharset()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (!word.isBlank()) frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException ioe) {
            log.error("Calculate word frequency, IO error: {}", ioe.getMessage());
        }

        List<Map.Entry<String, Integer>> data = new ArrayList<>(frequency.entrySet());
        data.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        data.forEach(
            item -> {
                if (item.getValue() < THRESHOLD) return;
                wordFrequency.append(item.getKey()).append(" ").append(item.getValue()).append("\n");
            }
        );

        return wordFrequency.toString();
    }
}
