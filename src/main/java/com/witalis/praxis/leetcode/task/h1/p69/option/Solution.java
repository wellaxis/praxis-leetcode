package com.witalis.praxis.leetcode.task.h1.p69.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 69
 * Name: Sqrt(x)
 * URL: <a href="https://leetcode.com/problems/sqrtx/">Sqrt(x)</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private Integer number;

    public Integer process() {
        return mySqrt(number);
    }

    public int mySqrt(int x) {
        int start = 1;
        int end = x;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (middle == x / middle) {
                return middle;
            } else if (middle > x / middle) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return end;
    }
}
