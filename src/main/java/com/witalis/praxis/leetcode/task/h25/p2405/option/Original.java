package com.witalis.praxis.leetcode.task.h25.p2405.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2405
 * Name: Optimal Partition of String
 * URL: <a href="https://leetcode.com/problems/optimal-partition-of-string/">Optimal Partition of String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return partitionString(string);
    }

    public int partitionString(String s) {
        if (s == null) return 0;

        int partitions = 0;

        final int[] frequency = new int[26];
        final char[] letters = s.toCharArray();
        for (final char letter : letters) {
            if (frequency[letter - 'a'] > 0) {
                partitions++;
                Arrays.fill(frequency, 0);
            }
            frequency[letter - 'a']++;
        }

        return partitions + 1;
    }
}
