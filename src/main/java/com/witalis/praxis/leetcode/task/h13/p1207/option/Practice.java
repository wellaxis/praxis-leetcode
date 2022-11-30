package com.witalis.praxis.leetcode.task.h13.p1207.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1207
 * Name: Unique Number of Occurrences
 * URL: <a href="https://leetcode.com/problems/unique-number-of-occurrences/">Unique Number of Occurrences</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Boolean process() {
        return uniqueOccurrences(numbers);
    }

    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        Map<Integer, Integer> data = new HashMap<>();
        for (int item : arr) {
            data.put(item, data.getOrDefault(item, 0) + 1);
        }

        int[] frequencies = data.values().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(frequencies);

        for (int i = 1; i < frequencies.length; i++) {
            if (frequencies[i] == frequencies[i - 1]) return false;
        }

        return true;
    }
}
