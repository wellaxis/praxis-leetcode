package com.witalis.praxis.leetcode.task.h1.p70.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 70
 * Name: Climbing Stairs
 * URL: https://leetcode.com/problems/climbing-stairs/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    private Map<Integer, Integer> cache = new HashMap<>();

    public Original(int number) {
        this.number = number;
    }

    public Integer process() {
        return climbStairs(number);
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        return recursiveClimb(n);
    }

    private int recursiveClimb(int n) {
        if (n == 0 || n == 1) return 1;

        if (cache.containsKey(n)) return cache.get(n);

        int res = recursiveClimb(n - 1) + recursiveClimb(n - 2);
        cache.put(n, res);
        return res;
    }
}
