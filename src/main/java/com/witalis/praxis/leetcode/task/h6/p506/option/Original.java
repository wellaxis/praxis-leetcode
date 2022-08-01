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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

        String value;
        int counter = 0;
        while (counter < size) {
            value = switch (counter) {
                case 0 -> "Gold Medal";
                case 1 -> "Silver Medal";
                case 2 -> "Bronze Medal";
                default -> "" + (counter + 1);
            };
            ranks[positions.get(score[size - (counter + 1)])] = value;
            counter++;
        }

        return ranks;
    }
}
