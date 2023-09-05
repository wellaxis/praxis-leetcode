package com.witalis.praxis.leetcode.task.h11.p1002.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1002
 * Name: Find Common Characters
 * URL: <a href="https://leetcode.com/problems/find-common-characters/">Find Common Characters</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;

    public List<String> process() {
        return commonChars(words);
    }

    public List<String> commonChars(String[] words) {
        if (words == null) return Collections.emptyList();

        List<String> chars = new ArrayList<>();

        final int n = words.length;
        final Map<Character, int[]> frequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] letters = words[i].toCharArray();
            for (char letter : letters) {
                frequencies.putIfAbsent(letter, new int[n]);
                frequencies.get(letter)[i]++;
            }
        }

        frequencies.forEach(
            (letter, frequency) -> {
                int count = Arrays.stream(frequency).min().orElse(0);
                while (count-- > 0) chars.add(String.valueOf(letter));
            }
        );

        return chars;
    }
}
