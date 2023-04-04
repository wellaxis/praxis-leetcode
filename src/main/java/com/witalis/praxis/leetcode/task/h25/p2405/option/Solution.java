package com.witalis.praxis.leetcode.task.h25.p2405.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2405
 * Name: Optimal Partition of String
 * URL: <a href="https://leetcode.com/problems/optimal-partition-of-string/">Optimal Partition of String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return partitionString(string);
    }

    public int partitionString(String s) {
        int count = 1;

        int map = 0;
        for (char c : s.toCharArray()) {
            if ((map & (1 << c)) != 0) {
                count++;
                map = 0;
            }
            map ^= (1 << c);
        }

        return count;
    }
}
