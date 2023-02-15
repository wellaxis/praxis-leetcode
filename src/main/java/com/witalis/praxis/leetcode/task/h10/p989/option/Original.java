package com.witalis.praxis.leetcode.task.h10.p989.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 989
 * Name: Add to Array-Form of Integer
 * URL: <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">Add to Array-Form of Integer</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int summand;

    public List<Integer> process() {
        return addToArrayForm(numbers, summand);
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        if (num == null) return Collections.emptyList();

        return num.length < 10 ? shortForm(num, k) : longForm(num, k);
    }

    private List<Integer> shortForm(int[] num, int k) {
        int number = Arrays.stream(num)
            .reduce(0, (sum, digit) -> sum * 10 + digit) + k;

        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        Collections.reverse(digits);

        return digits;
    }

    private List<Integer> longForm(int[] num, int k) {
        BigInteger number = Arrays.stream(num)
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ZERO, (sum, digit) -> sum.multiply(BigInteger.TEN).add(digit));
        number = number.add(BigInteger.valueOf(k));

        List<Integer> digits = new ArrayList<>();
        while (number.compareTo(BigInteger.ZERO) > 0) {
            digits.add(number.mod(BigInteger.TEN).intValue());
            number = number.divide(BigInteger.TEN);
        }
        Collections.reverse(digits);

        return digits;
    }
}
