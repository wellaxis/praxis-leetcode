package com.witalis.praxis.leetcode.task.h29.p2849.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2849
 * Name: Determine if a Cell Is Reachable at a Given Time
 * URL: <a href="https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/">Determine if a Cell Is Reachable at a Given Time</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int startX;
    private int startY;
    private int finishX;
    private int finishY;
    private int time;

    public Boolean process() {
        return isReachableAtTime(startX, startY, finishX, finishY, time);
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx <= 0 || sy <= 0 || fx <= 0 || fy <= 0 || t < 0) return false;

        int dx = Math.abs(fx - sx);
        int dy = Math.abs(fy - sy);
        int d = Math.max(dx, dy);

        if (d == 0 && t == 1) return false;
        if (d <= t) return true;

        return false;
    }
}
