package com.witalis.praxis.leetcode.task.p11.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 11
 * Name: Container With Most Water
 * URL: https://leetcode.com/problems/container-with-most-water/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] height;

    public Integer process() {
        return maxArea(height);
    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int max = 0;
        int l = 0;
        int r = height.length - 1;
        int h = 0;
        while (l < r) {
            if (height[l] <= h) {
                l++;
            } else if (height[r] <= h) {
                r--;
            } else {
                h++;
                var tmp = (r - l) * h;
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}
