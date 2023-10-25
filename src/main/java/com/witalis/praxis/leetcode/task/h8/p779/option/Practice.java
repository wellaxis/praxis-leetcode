package com.witalis.praxis.leetcode.task.h8.p779.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 779
 * Name: K-th Symbol in Gramma
 * URL: <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">K-th Symbol in Gramma</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int row;
    private int col;

    public Integer process() {
        return kthGrammar(row, col);
    }

    public int kthGrammar(int n, int k) {
        if (n < 0 || k < 0) return -1;
        if (n == 1) return 0;

        int x = kthGrammar(n - 1, (k + 1) / 2);

        if (x == 0) {
            return ((k & 1) != 0) ? 0 : 1;
        } else {
            return ((k & 1) != 0) ? 1 : 0;
        }
    }
}
