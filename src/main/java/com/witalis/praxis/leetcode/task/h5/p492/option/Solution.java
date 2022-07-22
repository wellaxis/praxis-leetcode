package com.witalis.praxis.leetcode.task.h5.p492.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 492
 * Name: Construct the Rectangle
 * URL: <a href="https://leetcode.com/problems/construct-the-rectangle/">Construct the Rectangle</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int area;

    public int[] process() {
        return constructRectangle(area);
    }

    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);

        while (area % width > 0) --width;

        return new int[] {area / width, width};
    }
}
