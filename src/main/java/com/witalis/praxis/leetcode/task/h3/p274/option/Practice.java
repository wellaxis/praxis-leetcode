package com.witalis.praxis.leetcode.task.h3.p274.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 274
 * Name: H-Index
 * URL: <a href="https://leetcode.com/problems/h-index/">H-Index</a>
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
        Arrays.sort(citations);

        int min = 0;
        int max = len - 1;
        int mid;
        while (min <= max) {
            mid = min + (max - min) / 2;
            if (len - mid <= citations[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return len - max - 1;
    }
}
