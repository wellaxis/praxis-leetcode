package com.witalis.praxis.leetcode.task.h15.p1496.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 1496
 * Name: Path Crossing
 * URL: <a href="https://leetcode.com/problems/path-crossing/">Path Crossing</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String path;

    public Boolean process() {
        return isPathCrossing(path);
    }

    record Point (int x, int y) {}

    public boolean isPathCrossing(String path) {
        if (path == null || path.isEmpty()) return false;

        int x = 0;
        int y = 0;
        Point point = new Point(x, y);

        final Set<Point> points = new HashSet<>();
        points.add(point);

        final int n = path.length();
        for (int i = 0; i < n; i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'N' -> y++;
                case 'E' -> x++;
                case 'S' -> y--;
                case 'W' -> x--;
                default -> throw new IllegalArgumentException("unexpected direction: " + direction);
            }
            point = new Point(x, y);
            if (points.contains(point)) return true;
            points.add(point);
        }

        return false;
    }
}
