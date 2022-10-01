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
        Arrays.sort(citations);

        for (int i = 0; i < len; i++) {
            if (len - i <= citations[i]) return len - i;
        }

        return 0;
    }
}
