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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;

    public List<String> process() {
        return commonChars(words);
    }

    public List<String> commonChars(String[] words) {
        if (words == null) return Collections.emptyList();

        List<String> chars = new ArrayList<>();

        final int n = words.length;

        int[][] frequencies = new int[26][n];
        for (int i = 0; i < n; i++)
            for (char letter : words[i].toCharArray())
                frequencies[letter - 'a'][i]++;

        for (int i = 0; i < 26; i++) {
            int counter = Integer.MAX_VALUE;
            for (int count : frequencies[i])
                if (count < counter)
                    counter = count;
            while (counter-- > 0)
                chars.add(String.valueOf((char) ('a' + i)));
        }

        return chars;
    }
}
