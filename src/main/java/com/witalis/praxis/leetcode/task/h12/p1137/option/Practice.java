package com.witalis.praxis.leetcode.task.h12.p1137.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * ID: 1137
 * Name: N-th Tribonacci Number
 * URL: <a href="https://leetcode.com/problems/n-th-tribonacci-number/">N-th Tribonacci Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return tribonacci(number);
    }

    public int tribonacci(int n) {
        if (n < 0) return n;

        return Stream.iterate(new int[] {0, 1, 1}, s -> new int[] {s[1], s[2], s[0] + s[1] + s[2]})
            .limit(n + 1L)
            .skip(n)
            .findFirst()
            .map(s -> s[0])
            .orElse(n);
    }
}
