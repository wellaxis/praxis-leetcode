package com.witalis.praxis.leetcode.task.h19.p1814.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * ID: 1814
 * Name: Count Nice Pairs in an Array
 * URL: <a href="https://leetcode.com/problems/count-nice-pairs-in-an-array/">Count Nice Pairs in an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return countNicePairs(numbers);
    }

    public int countNicePairs(int[] nums) {
        final HashMap<Integer, Integer> m = new HashMap<>();
        long r = 0;
        for (int n : nums) {
            int rev = 0;
            for (int q = n; q > 0; q /= 10) {
                rev = rev * 10 + q % 10;
            }
            r += m.merge(n - rev, 1, Integer::sum) - 1;
        }
        return (int) (r % 1000000007);
    }
}
