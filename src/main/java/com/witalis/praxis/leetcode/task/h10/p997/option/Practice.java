package com.witalis.praxis.leetcode.task.h10.p997.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 997
 * Name: Find the Town Judge
 * URL: <a href="https://leetcode.com/problems/find-the-town-judge/">Find the Town Judge</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[][] trust;

    public Integer process() {
        return findJudge(number, trust);
    }

    public int findJudge(int n, int[][] trust) {
        if (n <= 0 || trust == null) return -1;
        if (n == 1 && trust.length == 0) return 1;

        boolean[] people = new boolean[n];
        int[] trusts = new int[n];
        for (int[] ints : trust) {
            people[ints[0] - 1] = true;
            trusts[ints[1] - 1]++;
        }

        int index = -1;
        for (int i = 1; i <= n; i++) {
            if (!people[i - 1] && trusts[i - 1] == n - 1) {
                if (index > 0) return -1;
                index = i;
            }
        }

        return index;
    }
}
