package com.witalis.praxis.leetcode.task.h5.p476.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 476
 * Name: Number Complement
 * URL: <a href="https://leetcode.com/problems/number-complement/">Number Complement</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return findComplement(number);
    }

    public int findComplement(int num) {
        if (num == 0) return 1;

        int mask = 0;

        while (mask < num)
            mask = mask << 1 | 1;

        return ~num & mask;
    }
}
