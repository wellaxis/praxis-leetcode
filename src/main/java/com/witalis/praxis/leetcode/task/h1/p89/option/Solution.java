package com.witalis.praxis.leetcode.task.h1.p89.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 89
 * Name: Gray Code
 * URL: <a href="https://leetcode.com/problems/gray-code/">Gray Code</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public List<Integer> process() {
        return grayCode(number);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ (i >> 1));
        }

        return result;
    }
}
