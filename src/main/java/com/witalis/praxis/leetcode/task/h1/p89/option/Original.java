package com.witalis.praxis.leetcode.task.h1.p89.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 89
 * Name: Gray Code
 * URL: https://leetcode.com/problems/gray-code/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public List<Integer> process() {
        return grayCode(number);
    }

    public List<Integer> grayCode(int n) {
        if (n < 0) return Collections.emptyList();

        List<Integer> numbers = new ArrayList<>(List.of(0));

        if (n == 0) return numbers;

        numbers = grayCode(n - 1);

        int num = 1 << (n - 1);

        int size = numbers.size();
        for (int i = size - 1; i >= 0; i--) {
            numbers.add(num + numbers.get(i));
        }

        return numbers;
    }

    private boolean check(int n, int i, int j) {
        int difference = 0;

        while (n-- > 0) {
            if (BigInteger.valueOf(i).testBit(0) != BigInteger.valueOf(j).testBit(0)) difference++;
            i >>= 1;
            j >>= 1;
            if (difference > 1) return false;
        }
        return difference == 1;
    }
}
