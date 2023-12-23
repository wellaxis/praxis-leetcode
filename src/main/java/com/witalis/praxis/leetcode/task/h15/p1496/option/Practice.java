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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String path;

    public Boolean process() {
        return isPathCrossing(path);
    }

    public boolean isPathCrossing(String path) {
        if (path == null || path.isEmpty()) return false;

        int x = 0;
        int y = 0;
        String point = "(" + x + "," + y + ")";

        Set<String> points = new HashSet<>(Set.of(point));

        final char[] directions = path.toCharArray();
        for (char direction : directions) {
            switch (direction) {
                case 'N' -> y++;
                case 'E' -> x++;
                case 'S' -> y--;
                case 'W' -> x--;
                default -> throw new IllegalArgumentException("unexpected direction: " + direction);
            }
            point = "(" + x + "," + y + ")";
            if (points.contains(point)) return true;
            points.add(point);
        }

        return false;
    }
}
