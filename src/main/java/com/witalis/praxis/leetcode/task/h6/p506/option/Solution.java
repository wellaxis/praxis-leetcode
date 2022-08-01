package com.witalis.praxis.leetcode.task.h6.p506.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 506
 * Name: Relative Ranks
 * URL: <a href="https://leetcode.com/problems/relative-ranks/">Relative Ranks</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] score;

    public String[] process() {
        return findRelativeRanks(score);
    }

    public String[] findRelativeRanks(int[] score) {
        Integer[] index = new Integer[score.length];

        for (int i = 0; i < score.length; i++) index[i] = i;

        Arrays.sort(index, (a, b) -> (score[b] - score[a]));

        String[] result = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            if (i == 0) result[index[i]] = "Gold Medal";
            else if (i == 1) result[index[i]] = "Silver Medal";
            else if (i == 2) result[index[i]] = "Bronze Medal";
            else result[index[i]] = (i + 1) + "";
        }

        return result;
    }
}
