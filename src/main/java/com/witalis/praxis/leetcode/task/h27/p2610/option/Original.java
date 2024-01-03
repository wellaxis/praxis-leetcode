package com.witalis.praxis.leetcode.task.h27.p2610.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 2610
 * Name: Convert an Array Into a 2D Array With Conditions
 * URL: <a href="https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/">Convert an Array Into a 2D Array With Conditions</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<List<Integer>> process() {
        return findMatrix(numbers);
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        if (nums == null) return Collections.emptyList();

        final int n = nums.length;
        int[] frequencies = new int[n + 1];

        List<List<Integer>> matrix = new ArrayList<>();
        for (int num : nums) {
            if (frequencies[num] >= matrix.size()) {
                matrix.add(new ArrayList<>());
            }

            matrix.get(frequencies[num]).add(num);
            frequencies[num]++;
        }

        return matrix;
    }
}
