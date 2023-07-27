package com.witalis.praxis.leetcode.task.h22.p2141.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2141
 * Name: Maximum Running Time of N Computers
 * URL: <a href="https://leetcode.com/problems/maximum-running-time-of-n-computers/">Maximum Running Time of N Computers</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int computers;
    private int[] batteries;

    public Long process() {
        return maxRunTime(computers, batteries);
    }

    public long maxRunTime(int n, int[] batteries) {
        if (n <= 0 || batteries == null) return 0L;

        final int m = batteries.length;

        Arrays.sort(batteries);

        long min = 1L;
        long max = 0L;

        for (int battery : batteries)
            max += battery;
        max /= n;

        while (min < max) {
            long mid = min + (max - min + 1) / 2;

            int count = n;
            long time = 0;
            for (int battery : batteries) {
                time += battery;
                if (time >= mid) {
                    time -= mid;
                    count--;
                }
                if (count == 0) break;
            }

            if (count == 0) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }
}
