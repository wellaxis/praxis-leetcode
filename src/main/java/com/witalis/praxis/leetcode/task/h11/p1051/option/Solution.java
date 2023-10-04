package com.witalis.praxis.leetcode.task.h11.p1051.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1051
 * Name: Height Checker
 * URL: <a href="https://leetcode.com/problems/height-checker/">Height Checker</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] heights;

    public Integer process() {
        return heightChecker(heights);
    }

    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int height : heights)
            ++count[height];

        int ans = 0;
        int currentHeight = 1;
        for (int height : heights) {
            while (count[currentHeight] == 0)
                ++currentHeight;
            if (height != currentHeight)
                ++ans;
            --count[currentHeight];
        }

        return ans;
    }
}
