package com.witalis.praxis.leetcode.task.h1.p42.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 42
 * Name: Trapping Rain Water
 * URL: <a href="https://leetcode.com/problems/trapping-rain-water/">Trapping Rain Water</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] height;

    public Integer process() {
        return trap(height);
    }

    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int capacity = 0;

        int l = 0;
        int r = height.length - 1;

        int top = 1;
        while (true) {
            while (l < r && height[l] < top) l++;
            if (l >= r) break;

            while (r > l && height[r] < top) r--;
            if (r <= l) break;

            for (int i = l; i <= r; i++) {
                if (height[i] < top) {
                    capacity++;
                }
            }
            top++;
        }

        return capacity;
    }
}
