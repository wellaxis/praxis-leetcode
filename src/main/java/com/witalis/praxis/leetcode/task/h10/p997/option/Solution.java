package com.witalis.praxis.leetcode.task.h10.p997.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 997
 * Name: Find the Town Judge
 * URL: <a href="https://leetcode.com/problems/find-the-town-judge/">Find the Town Judge</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int[][] trust;

    public Integer process() {
        return findJudge(number, trust);
    }

    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;

        int[] count = new int[n + 1];
        for (int[] ints : trust) {
            count[ints[0]]--;
            count[ints[1]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == n - 1) return i;
        }

        return -1;
    }
}
