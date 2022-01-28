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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Practice(int number) {
        this.number = number;
    }

    private Map<Integer, Integer> cache = new HashMap<>();

    public Integer process() {
        return climbStairs(number);
    }

    public int climbStairs(int n) {
        return recursiveClimb(n);
    }

    private int recursiveClimb(int n) {
        if (n < 2) {
            return 1;
        } else if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int steps = recursiveClimb(n - 1) + recursiveClimb(n - 2);
            cache.put(n, steps);
            return steps;
        }
    }
}
