package com.witalis.praxis.leetcode.task.h8.p779.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 779
 * Name: K-th Symbol in Gramma
 * URL: <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">K-th Symbol in Gramma</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
            if (k % 2 != 0) return 0;
            else return 1;
        } else {
            if (k % 2 != 0) return 1;
            else return 0;
        }
    }
}
