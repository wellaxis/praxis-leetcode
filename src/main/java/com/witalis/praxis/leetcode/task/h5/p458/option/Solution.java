package com.witalis.praxis.leetcode.task.h5.p458.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 458
 * Name: Poor Pigs
 * URL: <a href="https://leetcode.com/problems/poor-pigs/">Poor Pigs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int buckets;
    private int minutesToDie;
    private int minutesToTest;

    public Integer process() {
        return poorPigs(buckets, minutesToDie, minutesToTest);
    }

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1));
    }
}
