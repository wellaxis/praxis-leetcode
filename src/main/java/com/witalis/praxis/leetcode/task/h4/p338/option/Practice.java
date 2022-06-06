package com.witalis.praxis.leetcode.task.h4.p338.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 338
 * Name: Counting Bits
 * URL: <a href="https://leetcode.com/problems/counting-bits/">Counting Bits</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public int[] process() {
        return countBits(number);
    }

    public int[] countBits(int n) {
        if (n < 0) return new int[] {};

        int[] ans = new int[n + 1];

        ans[0] = 0;
        if (n == 0) return ans;

        int power = 1;
        int num = 1;
        while (num <= n) {
            if (num == power << 1) power <<= 1;
            ans[num] = 1 + ans[num % power];
            num++;
        }

        return ans;
    }
}
