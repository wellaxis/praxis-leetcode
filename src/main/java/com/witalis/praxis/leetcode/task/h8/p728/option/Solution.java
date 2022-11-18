package com.witalis.praxis.leetcode.task.h8.p728.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 728
 * Name: Self Dividing Numbers
 * URL: <a href="https://leetcode.com/problems/self-dividing-numbers/">Self Dividing Numbers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int left;
    private int right;

    public List<Integer> process() {
        return selfDividingNumbers(left, right);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }

        return ans;
    }

    public boolean selfDividing(int n) {
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }

        return true;
    }
}
