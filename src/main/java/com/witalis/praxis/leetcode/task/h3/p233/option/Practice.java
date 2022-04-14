package com.witalis.praxis.leetcode.task.h3.p233.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 233
 * Name: Number of Digit One
 * URL: <a href="https://leetcode.com/problems/number-of-digit-one/">Number of Digit One</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return countDigitOne(number);
    }

    private Integer countDigitOne(int n) {
        return IntStream.rangeClosed(1, n)
            .flatMap(i -> String.valueOf(i).chars())
            .map(Character::getNumericValue)
            .filter(i -> i == 1)
            .sum();
    }
}
