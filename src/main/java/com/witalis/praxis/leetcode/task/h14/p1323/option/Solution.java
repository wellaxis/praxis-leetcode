package com.witalis.praxis.leetcode.task.h14.p1323.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1323
 * Name: Maximum 69 Number
 * URL: <a href="https://leetcode.com/problems/maximum-69-number/">Maximum 69 Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return maximum69Number(number);
    }

    public int maximum69Number(int num) {
        int numCopy = num;
        int indexSix = -1;
        int currDigit = 0;

        while (numCopy > 0) {
            if (numCopy % 10 == 6) indexSix = currDigit;

            numCopy /= 10;
            currDigit++;
        }

        return indexSix == -1 ? num : num + 3 * (int) Math.pow(10, indexSix);
    }
}
