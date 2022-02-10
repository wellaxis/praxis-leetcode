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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int index;

    public List<Integer> process() {
        return getRow(index);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);

        if (rowIndex == 0) return result;

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < result.size(); j++) {
                row.add(result.get(j - 1) + result.get(j));
            }

            row.add(1);
            result = row;
        }

        return result;
    }
}
