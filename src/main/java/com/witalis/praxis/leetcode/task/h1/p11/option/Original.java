package com.witalis.praxis.leetcode.task.h1.p11.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 11
 * Name: Container With Most Water
 * URL: <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] height;

    public Integer process() {
        return maxArea(height);
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int len = j - i;
                int val = Math.min(height[i], height[j]);
                int res = len * val;
                if (res > max) {
                    max = res;
                }
            }
        }
        return max;
    }
}
