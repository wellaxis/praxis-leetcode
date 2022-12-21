package com.witalis.praxis.leetcode.task.h9.p886.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 886
 * Name: Possible Bipartition
 * URL: <a href="https://leetcode.com/problems/possible-bipartition/">Possible Bipartition</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[][] dislikes;

    public Boolean process() {
        return possibleBipartition(number, dislikes);
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        return false;
    }
}
