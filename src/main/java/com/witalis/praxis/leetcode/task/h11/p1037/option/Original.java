package com.witalis.praxis.leetcode.task.h11.p1037.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1037
 * Name: Valid Boomerang
 * URL: <a href="https://leetcode.com/problems/valid-boomerang/">Valid Boomerang</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] points;

    public Boolean process() {
        return isBoomerang(points);
    }

    public boolean isBoomerang(int[][] points) {
        if (points == null || points.length != 3) return false;

        final int[] a = points[0];
        final int[] b = points[1];
        final int[] c = points[2];

        // collinear formula: x1(y2 – y3) + x2(y3 – y1) + x3(y1 – y2) = 0
        int boomerang = a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1]);

        return boomerang != 0;
    }
}
