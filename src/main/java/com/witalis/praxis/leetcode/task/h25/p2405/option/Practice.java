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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return partitionString(string);
    }

    public int partitionString(String s) {
        if (s == null || s.length() == 0) return 0;

        int partitions = 1;

        final boolean[] seen = new boolean[26];
        final char[] letters = s.toCharArray();
        for (final char letter : letters) {
            if (seen[letter - 'a']) {
                partitions++;
                Arrays.fill(seen, false);
            }
            seen[letter - 'a'] = true;
        }

        return partitions;
    }
}
