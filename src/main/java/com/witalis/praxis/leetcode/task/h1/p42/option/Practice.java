package com.witalis.praxis.leetcode.task.h1.p42.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 42
 * Name: Trapping Rain Water
 * URL: https://leetcode.com/problems/trapping-rain-water/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] height;

    public Integer process() {
        return trap(height);
    }

    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;

        int capacity = 0;

        Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < height.length; i++) {
            int value = height[i];
            if (map.containsKey(value)) {
                map.get(value).add(i);
            } else {
                map.put(value, new ArrayList<>(List.of(i)));
            }
        }

        int l = -1;
        int r = -1;

        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            int top = entry.getKey();
            int min = entry.getValue().stream().min(Comparator.naturalOrder()).orElse(-1);
            int max = entry.getValue().stream().max(Comparator.naturalOrder()).orElse(-1);
            if (l < 0) {
                l = min;
                r = max;
                if (l < r) {
                    capacity += fill(height, l, r, top);
                }
            } else {
                if (min < l) {
                    capacity += fill(height, min, l, top);
                    l = min;
                }
                if (max > r) {
                    capacity += fill(height, r, max, top);
                    r = max;
                }
            }
        }

        return capacity;
    }

    private int fill(int[] height, int left, int right, int level) {
        int capacity = 0;
        for (int i = left + 1; i < right; i++) {
            capacity += level - height[i];
        }
        return capacity;
    }
}
