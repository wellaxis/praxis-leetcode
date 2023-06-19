package com.witalis.praxis.leetcode.task.h18.p1732.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1732
 * Name: Find the Highest Altitude
 * URL: <a href="https://leetcode.com/problems/find-the-highest-altitude/">Find the Highest Altitude</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] gain;

    public Integer process() {
        return largestAltitude(gain);
    }

    public int largestAltitude(int[] gain) {
        if (gain == null) return 0;

        final int n = gain.length;

        int maxAltitude = 0;
        int currAltitude = 0;
        for (int i = 0; i < n; i++) {
            currAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currAltitude);
        }

        return maxAltitude;
    }
}
