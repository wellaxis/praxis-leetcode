package com.witalis.praxis.leetcode.task.h3.p275.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 275
 * Name: H-Index II
 * URL: <a href="https://leetcode.com/problems/h-index-ii/">H-Index II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] citations;

    public Integer process() {
        return hIndex(citations);
    }

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (len - mid <= citations[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return len - right - 1;
    }
}
