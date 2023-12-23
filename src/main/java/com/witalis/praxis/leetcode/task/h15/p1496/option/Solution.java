package com.witalis.praxis.leetcode.task.h15.p1496.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1496
 * Name: Path Crossing
 * URL: <a href="https://leetcode.com/problems/path-crossing/">Path Crossing</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String path;

    public Boolean process() {
        return isPathCrossing(path);
    }

    public boolean isPathCrossing(String path) {
        char[] directionChars = {'N', 'S', 'E', 'W'};
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 4; i++)
            map.put(directionChars[i], i);

        Set<String> set = new HashSet<>();
        set.add(Arrays.toString(new int[]{0, 0}));

        int x = 0;
        int y = 0;
        int length = path.length();
        for (int i = 0; i < length; i++) {
            char c = path.charAt(i);
            int index = map.get(c);
            int[] direction = directions[index];
            x += direction[0];
            y += direction[1];
            int[] array = {x, y};
            if (!set.add(Arrays.toString(array)))
                return true;
        }

        return false;
    }
}
