package com.witalis.praxis.leetcode.task.h3.p275.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 275
 * Name: H-Index II
 * URL: <a href="https://leetcode.com/problems/h-index-ii/">H-Index II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] citations;

    public Integer process() {
        return hIndex(citations);
    }

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int len = citations.length;
        int low = 0;
        int high = len;
        int mid;
        while (low < high) {
            mid = low + high + 1 >> 1;
            if (mid <= citations[len - mid]) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
