package com.witalis.praxis.leetcode.task.p526.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 526
 * Name: Beautiful Arrangement
 * URL: https://leetcode.com/problems/beautiful-arrangement/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return countArrangement(number);
    }

    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        return calculate(N, 1, visited, 0);
    }

    public int calculate(int N, int pos, boolean[] visited, int count) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                count = calculate(N, pos + 1, visited, count);
                visited[i] = false;
            }
        }
        return count;
    }
}
