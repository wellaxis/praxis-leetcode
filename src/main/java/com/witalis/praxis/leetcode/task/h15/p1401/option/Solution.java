package com.witalis.praxis.leetcode.task.h15.p1401.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1401
 * Name: Circle and Rectangle Overlapping
 * URL: <a href="https://leetcode.com/problems/circle-and-rectangle-overlapping/">Circle and Rectangle Overlapping</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
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
        // find the nearest point on the rectangle to the center of the circle
        int xn = Math.max(x1, Math.min(xCenter, x2));
        int yn = Math.max(y1, Math.min(yCenter, y2));

        // find the distance between the nearest point and the center of the circle
        int dx = xn - xCenter;
        int dy = yn - yCenter;

        return (dx * dx + dy * dy) <= radius * radius;
    }
}
