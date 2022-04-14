package com.witalis.praxis.leetcode.task.h6.p509.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

/**
 * ID: 509
 * Name: Fibonacci Number
 * URL: <a href="https://leetcode.com/problems/fibonacci-number/">Fibonacci Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return fib(number);
    }

    public int fib(int n) {
        if (n < 2) return n;

        return IntStream.range(2, n + 1)
            .boxed()
            .sorted()
            .collect(
                () -> new HashMap<>(Map.of(0, 0, 1, 1)),
                (map, num) -> map.computeIfAbsent(num, i -> map.get(i - 1) + map.get(i - 2)),
                HashMap::putAll
            ).get(n);
    }
}
