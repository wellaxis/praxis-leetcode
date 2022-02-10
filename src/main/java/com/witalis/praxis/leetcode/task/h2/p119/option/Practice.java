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
 * URL: https://leetcode.com/problems/pascals-triangle-ii/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int index;

    public List<Integer> process() {
        return getRow(index);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);

        if (rowIndex == 0) return result;

        for (int i = 1; i <= rowIndex; i++) {
            int raise = 1;
            for (int j = 1; j < i; j++) {
                raise = result.set(j, result.get(j) + raise);
            }
            result.add(1);
        }

        return result;
    }
}
