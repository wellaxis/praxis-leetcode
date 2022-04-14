package com.witalis.praxis.leetcode.task.h2.p120.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * ID: 120
 * Name: Triangle
 * URL: <a href="https://leetcode.com/problems/triangle/">Triangle</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<List<Integer>> triangle;

    public Integer process() {
        return minimumTotal(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;
        if (triangle.size() == 1) return Collections.min(triangle.get(0));

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j,
                    triangle.get(i).get(j) +
                        Math.min(
                            triangle.get(i + 1).get(j),
                            triangle.get(i + 1).get(j + 1)
                        )
                );
            }
        }

        return triangle.get(0).get(0);
    }
}
