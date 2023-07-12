package com.witalis.praxis.leetcode.task.h27.p2652.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 2652
 * Name: Sum Multiples
 * URL: <a href="https://leetcode.com/problems/sum-multiples/">Sum Multiples</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int numbers;

    public Integer process() {
        return sumOfMultiples(numbers);
    }

    public int sumOfMultiples(int n) {
        if (n <= 0) return 0;

        return IntStream.rangeClosed(1, n)
            .filter(i -> i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
            .sum();
    }
}
