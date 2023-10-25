package com.witalis.praxis.leetcode.task.h8.p779.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 779
 * Name: K-th Symbol in Gramma
 * URL: <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">K-th Symbol in Gramma</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int row;
    private int col;

    public Integer process() {
        return kthGrammar(row, col);
    }

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        // we assume the symbol at the target position is '1'
        int symbol = 1;

        for (int currRow = n; currRow > 1; --currRow) {
            int totalElements = (int) Math.pow(2, (currRow - 1));
            int halfElements = totalElements / 2;

            // if 'k' lies in the right half symbol, then we flip over to the respective left half symbol
            if (k > halfElements) {
                // flip the symbol
                symbol = 1 - symbol;
                // change the position after flipping
                k -= halfElements;
            }
        }

        // we reached the 1st row; if the symbol is not '0', we started with the wrong symbol
        if (symbol != 0) {
            // thus, the start symbol was '0', not '1'
            return 0;
        }

        // the start symbol was indeed what we started with, a '1'
        return 1;
    }

    public int kthGrammarMath(int n, int k) {
        int count = Integer.bitCount(k - 1);
        return count % 2 == 0 ? 0 : 1;
    }
}
