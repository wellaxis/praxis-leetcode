package com.witalis.praxis.leetcode.task.h16.p1523.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1523
 * Name: Count Odd Numbers in an Interval Range
 * URL: <a href="https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/">Count Odd Numbers in an Interval Range</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int low;
    private int high;

    public Integer process() {
        return countOdds(low, high);
    }

    public int countOdds(int low, int high) {
        int ans = (high - low) / 2;
        if ((low & 1) == 0 || (high & 1) == 0) ans++;

        return ans;
    }
}
