package com.witalis.praxis.leetcode.task.h11.p1018.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1018
 * Name: Binary Prefix Divisible By 5
 * URL: <a href="https://leetcode.com/problems/binary-prefix-divisible-by-5/">Binary Prefix Divisible By 5</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<Boolean> process() {
        return prefixesDivBy5(numbers);
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();

        int k = 0;
        for (int a : nums) {
            k = (k << 1 | a) % 5;
            ans.add(k == 0);
        }

        return ans;
    }
}
