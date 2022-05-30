package com.witalis.praxis.leetcode.task.h1.p52.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 52
 * Name: N-Queens II
 * URL: <a href="https://leetcode.com/problems/n-queens-ii/">N-Queens II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Solution(int number) {
        this.number = number;
    }

    public Integer process() {
        return totalNQueens(number);
    }

    private int ans;

    public int totalNQueens(int N) {
        ans = 0;
        place(0, 0, 0, 0, N);
        return ans;
    }

    private void place(int i, int vert, int ldiag, int rdiag, int N) {
        if (i == N) ans++;
        else for (int j = 0; j < N; j++) {
            int vmask = 1 << j;
            int lmask = 1 << (i + j);
            int rmask = 1 << (N - i - 1 + j);
            if ((vert & vmask) + (ldiag & lmask) + (rdiag & rmask) > 0) continue;
            place(i + 1, vert | vmask, ldiag | lmask, rdiag | rmask, N);
        }
    }
}
