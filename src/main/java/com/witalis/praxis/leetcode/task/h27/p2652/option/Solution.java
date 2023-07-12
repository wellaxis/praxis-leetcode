package com.witalis.praxis.leetcode.task.h27.p2652.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2652
 * Name: Sum Multiples
 * URL: <a href="https://leetcode.com/problems/sum-multiples/">Sum Multiples</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int numbers;

    public Integer process() {
        return sumOfMultiples(numbers);
    }

    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 3; i <= n; i += 3)
            sum += i;

        for (int i = 5; i <= n; i += 5)
            if (i % 3 != 0)
                sum += i;

        for (int i = 7; i <= n; i += 7)
            if (i % 3 != 0 && i % 5 != 0)
                sum += i;

        return sum;
    }
}
