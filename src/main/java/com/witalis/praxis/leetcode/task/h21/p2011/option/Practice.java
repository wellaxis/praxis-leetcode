package com.witalis.praxis.leetcode.task.h21.p2011.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2011
 * Name: Final Value of Variable After Performing Operations
 * URL: <a href="https://leetcode.com/problems/final-value-of-variable-after-performing-operations/">Final Value of Variable After Performing Operations</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] operations;

    public Integer process() {
        return finalValueAfterOperations(operations);
    }

    public int finalValueAfterOperations(String[] operations) {
        if (operations == null || operations.length == 0) return 0;

        int value = 0;
        for (String operation : operations)
            value += (operation.charAt(1) == '+') ? 1 : -1;

        return value;
    }
}
