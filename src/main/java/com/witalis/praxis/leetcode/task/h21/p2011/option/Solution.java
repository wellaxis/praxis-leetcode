package com.witalis.praxis.leetcode.task.h21.p2011.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2011
 * Name: Final Value of Variable After Performing Operations
 * URL: <a href="https://leetcode.com/problems/final-value-of-variable-after-performing-operations/">Final Value of Variable After Performing Operations</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] operations;

    public Integer process() {
        return finalValueAfterOperations(operations);
    }

    public int finalValueAfterOperations(String[] operations) {
        int total = 0;
        for (String s : operations) {
            if (s.charAt(1) == '-') {
                total--;
            } else {
                total++;
            }
        }

        return total;
    }
}
