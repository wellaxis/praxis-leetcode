package com.witalis.praxis.leetcode.task.h26.p2549.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 2549
 * Name: Count Distinct Numbers on Board
 * URL: <a href="https://leetcode.com/problems/count-distinct-numbers-on-board/">Count Distinct Numbers on Board</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return distinctIntegers(number);
    }

    public int distinctIntegers(int n) {
        if (n < 0) return n;
        if (n < 3) return 1;

        Set<Integer> numbers = new HashSet<>();
        recursiveCount(numbers, n);

        return numbers.size();
    }

    private void recursiveCount(Set<Integer> numbers, int number) {
        if (number <= 1) return;
        if (numbers.contains(number)) return;

        numbers.add(number);
        if ((number & 1) == 0 && number > 2) {
            // even
            recursiveCount(numbers, number - 1);
        } else {
            // odd
            number--;
            for (int i = 1; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    if (number / i == i) {
                        recursiveCount(numbers, i);
                    } else {
                        recursiveCount(numbers, i);
                        recursiveCount(numbers, number / i);
                    }
                }
            }
        }
    }
}
