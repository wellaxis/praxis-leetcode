package com.witalis.praxis.leetcode.task.h5.p492.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 492
 * Name: Construct the Rectangle
 * URL: <a href="https://leetcode.com/problems/construct-the-rectangle/">Construct the Rectangle</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int area;

    public int[] process() {
        return constructRectangle(area);
    }

    public int[] constructRectangle(int area) {
        if (area <= 0) return new int[0];

        for (int i = (int) Math.ceil(Math.sqrt(area)); i <= area; i++) {
            if (area % i == 0) return new int[] {i, area / i};
        }

        return new int[] {area, 1};
    }
}
