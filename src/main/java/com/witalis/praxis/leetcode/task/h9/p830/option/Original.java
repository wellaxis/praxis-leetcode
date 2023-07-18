package com.witalis.praxis.leetcode.task.h9.p830.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ID: 830
 * Name: Positions of Large Groups
 * URL: <a href="https://leetcode.com/problems/positions-of-large-groups/">Positions of Large Groups</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public List<List<Integer>> process() {
        return largeGroupPositions(string);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null) return Collections.emptyList();

        final List<List<Integer>> positions = new LinkedList<>();
        final char[] letters = (s + ".").toCharArray();
        final int n = letters.length;

        int index = 0;
        for (int i = 1; i < n; i++) {
            if (letters[i] != letters[index]) {
                if (i - index >= 3)
                    positions.add(List.of(index, i - 1));
                index = i;
            }
        }

        return positions;
    }
}
