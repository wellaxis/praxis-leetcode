package com.witalis.praxis.leetcode.task.h2.p149.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 149
 * Name: Max Points on a Line
 * URL: <a href="https://leetcode.com/problems/max-points-on-a-line/">Max Points on a Line</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] points;

    public Integer process() {
        return maxPoints(points);
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1)  return 1;

        int result = 2;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    cnt.merge(
                        Math.atan2(
                            points[j][1] - points[i][1],
                            points[j][0] - points[i][0]
                        ),
                        1,
                        Integer::sum
                    );
                }
            }
            result = Math.max(result, Collections.max(cnt.values()) + 1);
        }

        return result;
    }
}
