package com.witalis.praxis.leetcode.task.h8.p728.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 728
 * Name: Self Dividing Numbers
 * URL: <a href="https://leetcode.com/problems/self-dividing-numbers/">Self Dividing Numbers</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int left;
    private int right;

    public List<Integer> process() {
        return selfDividingNumbers(left, right);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        if (left <= 0 || right <= 0) return Collections.emptyList();

        return IntStream.rangeClosed(left, right)
            .filter(Original::isSelfDividing)
            .boxed()
            .toList();
    }

    public static boolean isSelfDividing(int number) {
        if (number <= 0) return false;

        int num = number;
        int mod;
        while (num > 0) {
            mod = num % 10;
            if (mod == 0 || number % mod != 0) return false;
            num /= 10;
        }

        return true;
    }
}
