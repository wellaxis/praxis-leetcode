package com.witalis.praxis.leetcode.task.h22.p2103.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 2103
 * Name: Rings and Rods
 * URL: <a href="https://leetcode.com/problems/rings-and-rods/">Rings and Rods</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String rings;

    public Integer process() {
        return countPoints(rings);
    }

    public int countPoints(String rings) {
        if (rings == null || rings.isEmpty()) return 0;

        Map<Integer, int[]> distribution = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 2) {
            int rod = rings.charAt(i + 1) - '0';
            distribution.putIfAbsent(rod, new int[3]);
            int[] colors = distribution.get(rod);

            char color = rings.charAt(i);
            switch (color) {
                case 'R' -> colors[0]++;
                case 'G' -> colors[1]++;
                case 'B' -> colors[2]++;
            }
        }

        return (int) distribution.values().stream()
            .filter(colors -> Arrays.stream(colors).filter(i -> i > 0).count() == 3)
            .count();
    }
}
