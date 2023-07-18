package com.witalis.praxis.leetcode.task.h9.p830.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 830
 * Name: Positions of Large Groups
 * URL: <a href="https://leetcode.com/problems/positions-of-large-groups/">Positions of Large Groups</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public List<List<Integer>> process() {
        return largeGroupPositions(string);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        final int n = s.length();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0, j = 0; i < n; i = j) {
            while (j < n && s.charAt(j) == s.charAt(i))
                ++j;
            if (j - i >= 3)
                ans.add(Arrays.asList(i, j - 1));
        }

        return ans;
    }
}
