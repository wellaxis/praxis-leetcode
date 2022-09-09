package com.witalis.praxis.leetcode.task.h3.p223.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 223
 * Name: Rectangle Area
 * URL: <a href="https://leetcode.com/problems/rectangle-area/">Rectangle Area</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
        int a = (ax2 - ax1) * (ay2 - ay1);
        int b = (bx2 - bx1) * (by2 - by1);

        if (a == 0 || b == 0) return a + b;

        int i = 0;
        if (ax1 < bx2 && bx1 < ax2 && ay1 < by2 && by1 < ay2) {
            int l;
            if ((ax1 - bx1) * (ax2 - bx2) > 0) {
                l = Math.min(ax2 - bx1, bx2 - ax1);
            } else {
                l = Math.min(ax2 - ax1, bx2 - bx1);
            }

            int h;
            if ((ay1 - by1) * (ay2 - by2) > 0) {
                h = Math.min(ay2 - by1, by2 - ay1);
            } else {
                h = Math.min(ay2 - ay1, by2 - by1);
            }

            i = l * h;
        }

        return a + b - i;
    }
}
