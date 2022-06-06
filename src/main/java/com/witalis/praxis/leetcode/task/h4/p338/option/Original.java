package com.witalis.praxis.leetcode.task.h4.p338.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 338
 * Name: Counting Bits
 * URL: <a href="https://leetcode.com/problems/counting-bits/">Counting Bits</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public int[] process() {
        return countBits(number);
    }

    public int[] countBits(int n) {
        if (n < 0) return new int[0];

        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.toBinaryString(i).replace("0", "").length();
        }

        return ans;
    }
}
