package com.witalis.praxis.leetcode.task.p118.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 118
 * Name: Pascal's Triangle
 * URL: https://leetcode.com/problems/pascals-triangle/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int rows;

    public List<List<Integer>> process() {
        return generate(rows);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();

        List<List<Integer>> triangle = new ArrayList<>(numRows);

        List<Integer> previous = new ArrayList<>(1);
        previous.add(1);
        triangle.add(previous);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            int counter = 1;
            while (counter < previous.size()) {
                row.add(previous.get(counter - 1) + previous.get(counter));
                counter++;
            }

            row.add(1);
            triangle.add(row);
            previous = row;
        }
        return triangle;
    }
}
