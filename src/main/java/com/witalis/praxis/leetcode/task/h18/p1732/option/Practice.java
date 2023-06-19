package com.witalis.praxis.leetcode.task.h18.p1732.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1732
 * Name: Find the Highest Altitude
 * URL: <a href="https://leetcode.com/problems/find-the-highest-altitude/">Find the Highest Altitude</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] gain;

    public Integer process() {
        return largestAltitude(gain);
    }

    public int largestAltitude(int[] gain) {
        if (gain == null) return 0;

        int maxAltitude = 0;
        int currAltitude = 0;
        for (int point : gain)
            maxAltitude = Math.max(maxAltitude, currAltitude += point);

        return maxAltitude;
    }
}
