package com.witalis.praxis.leetcode.task.h9.p836.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 836
 * Name: Rectangle Overlap
 * URL: <a href="https://leetcode.com/problems/rectangle-overlap/">Rectangle Overlap</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] rectangle1;
    private int[] rectangle2;

    public Boolean process() {
        return isRectangleOverlap(rectangle1, rectangle2);
    }

    public record Point(int x, int y) {}

    public record Rectangle(Point bottomLeft, Point topRight) {}

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1 == null || rec2 == null) return false;

        final Rectangle r1 = new Rectangle(new Point(rec1[0], rec1[1]), new Point(rec1[2], rec1[3]));
        final Rectangle r2 = new Rectangle(new Point(rec2[0], rec2[1]), new Point(rec2[2], rec2[3]));

        final int[] intersection = new int[] {
            Math.max(r1.bottomLeft.x, r2.bottomLeft.x),
            Math.min(r1.topRight.x, r2.topRight.x),
            Math.max(r1.bottomLeft.y, r2.bottomLeft.y),
            Math.min(r1.topRight.y, r2.topRight.y)
        };

        return intersection[0] < intersection[1] && intersection[2] < intersection[3];
    }
}
