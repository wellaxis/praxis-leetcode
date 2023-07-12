package com.witalis.praxis.leetcode.task.h27.p2652.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2652
 * Name: Sum Multiples
 * URL: <a href="https://leetcode.com/problems/sum-multiples/">Sum Multiples</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int numbers;

    public Integer process() {
        return sumOfMultiples(numbers);
    }

    public int sumOfMultiples(int n) {
        if (n <= 0) return 0;

        int sum = 0;
        for (int i = 3; i <= n; i++)
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                sum += i;

        return sum;
    }
}
