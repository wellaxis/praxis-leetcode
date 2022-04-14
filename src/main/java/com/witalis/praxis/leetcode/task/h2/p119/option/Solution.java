package com.witalis.praxis.leetcode.task.h2.p119.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 119
 * Name: Pascal's Triangle II
 * URL: <a href="https://leetcode.com/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int index;

    public List<Integer> process() {
        return getRow(index);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(1);
            for (int j = i; j >= 0; j--) {
                if (j != 0 && j != i) {
                    result.set(j, result.get(j) + result.get(j - 1));
                }
            }
        }

        return result;
    }
}
