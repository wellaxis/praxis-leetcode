package com.witalis.praxis.leetcode.task.h15.p1401.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1401
 * Name: Circle and Rectangle Overlapping
 * URL: <a href="https://leetcode.com/problems/circle-and-rectangle-overlapping/">Circle and Rectangle Overlapping</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int circleRadius;
    private int circleXCenter;
    private int circleYCenter;
    private int rectangleX1;
    private int rectangleY1;
    private int rectangleX2;
    private int rectangleY2;

    public Boolean process() {
        return checkOverlap(circleRadius, circleXCenter, circleYCenter, rectangleX1, rectangleY1, rectangleX2, rectangleY2);
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // up
        for (int y = y1; y <= y2; y++) {
            if (isOverlapping(radius, xCenter, yCenter, x1, y)) return true;
        }
        // right
        for (int x = x1; x <= x2; x++) {
            if (isOverlapping(radius, xCenter, yCenter, x, y2)) return true;
        }
        // down
        for (int y = y2; y >= y1; y--) {
            if (isOverlapping(radius, xCenter, yCenter, x2, y)) return true;
        }
        // left
        for (int x = x2; x >= x1; x--) {
            if (isOverlapping(radius, xCenter, yCenter, x, y1)) return true;
        }

        return (x1 <= xCenter && xCenter <= x2) && (y1 <= yCenter && yCenter <= y2);
    }

    private static boolean isOverlapping(int radius, int xCenter, int yCenter, int x, int y) {
        return Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2) - Math.pow(radius, 2) <= 0;
    }
}
