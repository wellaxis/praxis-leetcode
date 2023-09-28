package com.witalis.praxis.leetcode.task.h11.p1009.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1009
 * Name: Complement of Base 10 Integer
 * URL: <a href="https://leetcode.com/problems/complement-of-base-10-integer/">Complement of Base 10 Integer</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return bitwiseComplement(number);
    }

    public int bitwiseComplement(int n) {
        int mask = 1;
        while (mask < n)
            mask = (mask << 1) + 1;
        return mask ^ n;
    }
}
