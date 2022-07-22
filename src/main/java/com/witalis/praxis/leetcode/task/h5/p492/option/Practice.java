package com.witalis.praxis.leetcode.task.h5.p492.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 492
 * Name: Construct the Rectangle
 * URL: <a href="https://leetcode.com/problems/construct-the-rectangle/">Construct the Rectangle</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int area;

    public int[] process() {
        return constructRectangle(area);
    }

    public int[] constructRectangle(int area) {
        if (area <= 0) return new int[0];

        for (int i = (int) Math.sqrt(area); i > 1; i--) {
            if (area % i == 0) return new int[] {area / i, i};
        }

        return new int[] {area, 1};
    }
}
