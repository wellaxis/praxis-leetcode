package com.witalis.praxis.leetcode.task.h6.p509.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 509
 * Name: Fibonacci Number
 * URL: https://leetcode.com/problems/fibonacci-number/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return fib(number);
    }

    public int fib(int n) {
        Map<Integer, Integer> cache = new HashMap<>() {{
            put(0, 0);
            put(1, 1);
        }};
        return fibonacci(n, cache);
    }

    public int fibonacci(int n, Map<Integer, Integer> cache) {
        int counter = 2;
        while (counter <= n) {
            cache.computeIfAbsent(counter, k -> cache.get(k - 1) + cache.get(k - 2));
            counter++;
        }
        return cache.get(n);
    }
}
