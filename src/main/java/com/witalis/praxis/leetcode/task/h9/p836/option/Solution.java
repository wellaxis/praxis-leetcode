package com.witalis.praxis.leetcode.task.h9.p836.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 836
 * Name: Rectangle Overlap
 * URL: <a href="https://leetcode.com/problems/rectangle-overlap/">Rectangle Overlap</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] rectangle1;
    private int[] rectangle2;

    public Boolean process() {
        return isRectangleOverlap(rectangle1, rectangle2);
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // width > 0
        boolean width = Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]);
        // height > 0
        boolean height = Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);

        return width && height;
    }
}
