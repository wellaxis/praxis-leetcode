package com.witalis.praxis.leetcode.task.h23.p2244.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2244
 * Name: Minimum Rounds to Complete All Tasks
 * URL: <a href="https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/">Minimum Rounds to Complete All Tasks</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] tasks;

    public Integer process() {
        return minimumRounds(tasks);
    }

    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);

        int res = 0;
        for (int i = 0; i < tasks.length;) {
            int j = i + 1;
            while (j < tasks.length && tasks[j] == tasks[i]) j++;
            if (j == i + 1) return -1;
            res += compute(j - i);
            i = j;
        }

        return res;
    }

    private int compute(int i) {
        if (i % 3 == 0) return i / 3;
        if (i % 3 == 2) return (i - 2) / 3 + 1;
        return (i - 4) / 3 + 2;
    }
}
