package com.witalis.praxis.leetcode.task.h2.p118.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 118
 * Name: Pascal's Triangle
 * URL: https://leetcode.com/problems/pascals-triangle/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int rows;

    public List<List<Integer>> process() {
        return generate(rows);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> rowList = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            rowList.add(0, 1);

            for (int j = 1; j < i - 1; j++) {
                rowList.set(j, rowList.get(j) + rowList.get(j + 1));
            }

            list.add(new ArrayList<>(rowList));
        }

        return list;
    }
}
