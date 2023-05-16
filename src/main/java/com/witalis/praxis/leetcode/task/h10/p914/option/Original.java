package com.witalis.praxis.leetcode.task.h10.p914.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ID: 914
 * Name: X of a Kind in a Deck of Cards
 * URL: <a href="https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/">X of a Kind in a Deck of Cards</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return hasGroupsSizeX(numbers);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length <= 1) return false;

        final Map<Integer, Long> frequencies = Arrays.stream(deck)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final int[] divisor = new int[] {0};
        frequencies.forEach((key, value) -> divisor[0] = (divisor[0] == 0) ? value.intValue() : gcd(divisor[0], value.intValue()));

        return divisor[0] >= 2;
    }

    // greatest common divisor
    private static int gcd(int x, int y) {
        return BigInteger.valueOf(x).gcd(BigInteger.valueOf((y))).intValue();
    }
}
