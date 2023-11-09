package com.witalis.praxis.leetcode.task.h29.p2849.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2849
 * Name: Determine if a Cell Is Reachable at a Given Time
 * URL: <a href="https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/">Determine if a Cell Is Reachable at a Given Time</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int startX;
    private int startY;
    private int finishX;
    private int finishY;
    private int time;

    public Boolean process() {
        return isReachableAtTime(startX, startY, finishX, finishY, time);
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx - fx);
        int height = Math.abs(sy - fy);

        if (width == 0 && height == 0 && t == 1)
            return false;
        return t >= Math.max(width, height);
    }
}
