package com.witalis.praxis.leetcode.task.h8.p771.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 771
 * Name: Jewels and Stones
 * URL: <a href="https://leetcode.com/problems/jewels-and-stones/">Jewels and Stones</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String jewels;
    private String stones;

    public Integer process() {
        return numJewelsInStones(jewels, stones);
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        final int n = stones.length();
        final int m = jewels.length();
        for (int i = 0; i < n; i++) {
            char x = stones.charAt(i);
            for (int j = 0; j < m; j++) {
                char y = jewels.charAt(j);
                if (x == y) {
                    count++;
                }
            }
        }

        return count;
    }
}
