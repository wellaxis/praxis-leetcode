package com.witalis.praxis.leetcode.task.h3.p223.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 223
 * Name: Rectangle Area
 * URL: <a href="https://leetcode.com/problems/rectangle-area/">Rectangle Area</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int ax1;
    private int ay1;
    private int ax2;
    private int ay2;
    private int bx1;
    private int by1;
    private int bx2;
    private int by2;

    public Integer process() {
        return computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        final long x = Math.max(ax1, bx1) < Math.min(ax2, bx2) ? (Math.min(ax2, bx2) - Math.max(ax1, bx1)) : 0;
        final long y = Math.max(ay1, by1) < Math.min(ay2, by2) ? (Math.min(ay2, by2) - Math.max(ay1, by1)) : 0;

        return (int) ((ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - x * y);
    }
}
