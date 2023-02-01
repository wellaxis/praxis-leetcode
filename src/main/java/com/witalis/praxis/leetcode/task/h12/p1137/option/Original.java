package com.witalis.praxis.leetcode.task.h12.p1137.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ID: 1137
 * Name: N-th Tribonacci Number
 * URL: <a href="https://leetcode.com/problems/n-th-tribonacci-number/">N-th Tribonacci Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return tribonacci(number);
    }

    public int tribonacci(int n) {
        Map<Integer, Integer> cache = new HashMap<>() {{
            put(0, 0);
            put(1, 1);
            put(2, 1);
        }};
        return tribonacci(n, cache);
    }

    public int tribonacci(int n, Map<Integer, Integer> cache) {
        int counter = 3;
        while (counter <= n) {
            cache.computeIfAbsent(counter, k -> cache.get(k - 1) + cache.get(k - 2) + cache.get(k - 3));
            counter++;
        }
        return cache.get(n);
    }
}
