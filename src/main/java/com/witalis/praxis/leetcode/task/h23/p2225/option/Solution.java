package com.witalis.praxis.leetcode.task.h23.p2225.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * ID: 2225
 * Name: Find Players With Zero or One Losses
 * URL: <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/">Find Players With Zero or One Losses</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matches;

    public List<List<Integer>> process() {
        return findWinners(matches);
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        var resultMap = new HashMap<Integer, Integer>();
        for (var match : matches) {
            resultMap.putIfAbsent(match[0], 0);
            resultMap.merge(match[1], 1, Integer::sum);
        }

        var winners = new ArrayList<Integer>();
        var lostOneMatch = new ArrayList<Integer>();
        for (var entry : resultMap.entrySet()) {
            if (entry.getValue() == 0) {
                winners.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                lostOneMatch.add(entry.getKey());
            }
        }
        Collections.sort(winners);
        Collections.sort(lostOneMatch);

        return List.of(winners, lostOneMatch);
    }
}
