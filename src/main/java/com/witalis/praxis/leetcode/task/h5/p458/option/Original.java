package com.witalis.praxis.leetcode.task.h5.p458.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 458
 * Name: Poor Pigs
 * URL: <a href="https://leetcode.com/problems/poor-pigs/">Poor Pigs</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int buckets;
    private int minutesToDie;
    private int minutesToTest;

    public Integer process() {
        return poorPigs(buckets, minutesToDie, minutesToTest);
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets <= 0 || minutesToDie <= 0 || minutesToTest <= 0) return 0;

        int pigs = 0;

        int test = minutesToTest / minutesToDie;
        while (Math.pow(test + 1D, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }
}
