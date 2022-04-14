package com.witalis.praxis.leetcode.task.h1.p60.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 60
 * Name: Permutation Sequence
 * URL: <a href="https://leetcode.com/problems/permutation-sequence/">Permutation Sequence</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int position;

    public String process() {
        return getPermutation(number, position);
    }

    public String getPermutation(int n, int k) {
        if (n <= 1) return String.valueOf(n);

        StringBuilder permutation = new StringBuilder();
        List<Integer> numbers = new ArrayList<>(IntStream.rangeClosed(1, n).boxed().toList());

        k--;
        while (n > 0) {
            int factor = factorial(n - 1);
            int index = k / factor;
            permutation.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factor;
            n--;
        }

        return permutation.toString();
    }

    private static int factorial(int n) {
        return IntStream.rangeClosed(1, n).reduce(1, (int x, int y) -> x * y);
    }
}
