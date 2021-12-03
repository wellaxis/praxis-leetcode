package com.witalis.praxis.leetcode.task.p233.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 233
 * Name: Number of Digit One
 * URL: https://leetcode.com/problems/number-of-digit-one/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return countDigitOne(number);
    }

    private Integer countDigitOne(int n) {
        return (int) IntStream.rangeClosed(1, n)
            .boxed()
            .flatMapToInt(i -> String.valueOf(i).chars()
                .map(Character::getNumericValue)
            )
            .filter(i -> i == 1)
            .count();
    }
}
