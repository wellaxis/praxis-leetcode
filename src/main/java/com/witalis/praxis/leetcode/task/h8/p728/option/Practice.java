package com.witalis.praxis.leetcode.task.h8.p728.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 728
 * Name: Self Dividing Numbers
 * URL: <a href="https://leetcode.com/problems/self-dividing-numbers/">Self Dividing Numbers</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int left;
    private int right;

    public List<Integer> process() {
        return selfDividingNumbers(left, right);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        if (left <= 0 || right <= 0) return Collections.emptyList();

        List<Integer> numbers = new ArrayList<>();

        int num;
        int mod;
        for (int number = left; number <= right; number++) {
            num = number;
            while (num > 0) {
                mod = num % 10;
                if (mod == 0 || number % mod != 0) break;
                num /= 10;
            }
            if (num == 0) numbers.add(number);
        }

        return numbers;
    }
}
