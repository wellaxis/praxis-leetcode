package com.witalis.praxis.leetcode.task.h5.p458.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 458
 * Name: Poor Pigs
 * URL: <a href="https://leetcode.com/problems/poor-pigs/">Poor Pigs</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int buckets;
    private int minutesToDie;
    private int minutesToTest;

    public Integer process() {
        return poorPigs(buckets, minutesToDie, minutesToTest);
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets <= 0 || minutesToDie <= 0 || minutesToTest <= 0) return 0;

        int pigs = 0;

        int test = 1 + minutesToTest / minutesToDie;
        while (Math.pow(test, pigs) < buckets) pigs++;

        return pigs;
    }
}
