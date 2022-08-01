package com.witalis.praxis.leetcode.task.h6.p506.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 506
 * Name: Relative Ranks
 * URL: <a href="https://leetcode.com/problems/relative-ranks/">Relative Ranks</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] score;

    public String[] process() {
        return findRelativeRanks(score);
    }

    public String[] findRelativeRanks(int[] score) {
        if (score == null || score.length == 0) return new String[0];

        int size = score.length;

        String[] ranks = new String[size];

        Map<Integer, Integer> positions = new HashMap<>(size);
        for (int i = 0; i < size; i++) positions.put(score[i], i);

        Arrays.sort(score);

        for (int i = 1; i <= size; i++) {
            ranks[positions.get(score[size - i])] = switch (i) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> "" + i;
            };
        }

        return ranks;
    }
}
