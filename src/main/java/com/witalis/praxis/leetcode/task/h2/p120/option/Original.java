package com.witalis.praxis.leetcode.task.h2.p120.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ID: 120
 * Name: Triangle
 * URL: <a href="https://leetcode.com/problems/triangle/">Triangle</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<List<Integer>> triangle;

    public Integer process() {
        return minimumTotal(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) return 0;

        if (triangle.size() == 1) {
            return triangle.get(0).stream()
                .min(Integer::compareTo).orElse(0);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                row.set(j, row.get(j) + Math.min(
                    triangle.get(i + 1).get(j),
                    triangle.get(i + 1).get(j + 1)
                ));
            }
        }

        return triangle.get(0).get(0);
    }
}
