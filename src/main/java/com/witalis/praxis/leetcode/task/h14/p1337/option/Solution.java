package com.witalis.praxis.leetcode.task.h14.p1337.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1337
 * Name: The K Weakest Rows in a Matrix
 * URL: <a href="https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/">The K Weakest Rows in a Matrix</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] matrix;
    private int quantity;

    public int[] process() {
        return kWeakestRows(matrix, quantity);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] arr = new int[mat.length];

        int idx = 0;
        for (int[] rows : mat) {
            int low = 0;
            int high = rows.length - 1;
            int ans = -1;
            while (low <= high) {
                int mid = low + ((high - low) / 2);
                if (rows[mid] == 1) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            arr[idx++] = ans + 1;
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            ans[i] = minIdx;
            arr[minIdx] = Integer.MAX_VALUE;
        }

        return ans;
    }
}
