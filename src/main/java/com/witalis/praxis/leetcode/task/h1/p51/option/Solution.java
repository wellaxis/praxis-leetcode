package com.witalis.praxis.leetcode.task.h1.p51.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 51
 * Name: N-Queens
 * URL: <a href="https://leetcode.com/problems/n-queens/">N-Queens</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public List<List<String>> process() {
        return solveNQueens(number);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        solve(
            0,
            n,
            new ArrayList<>(),
            new boolean[n],
            new boolean[2 * n],
            new boolean[2 * n],
            solutions
        );

        return solutions;
    }

    private void solve(
        int row,
        int n,
        List<String> tmp,
        boolean[] cl,
        boolean[] dg1,
        boolean[] dg2,
        List<List<String>> res
    ) {
        if (row == n) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < n; i++) {
            int id1 = i - row + n;
            int id2 = i + row;
            if (!cl[i] && !dg1[id1] && !dg2[id2]) {
                char[] r = new char[n];
                Arrays.fill(r, '.');
                r[i] = 'Q';
                tmp.add(new String(r));
                cl[i] = true;
                dg1[id1] = true;
                dg2[id2] = true;
                solve(row + 1, n, tmp, cl, dg1, dg2, res);
                cl[i] = false;
                dg1[id1] = false;
                dg2[id2] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
