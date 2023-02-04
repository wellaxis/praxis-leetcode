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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Practice(int number) {
        this.number = number;
    }

    public Integer process() {
        return distinctIntegers(number);
    }

    private Set<Integer> numbers = new HashSet<>();

    public int distinctIntegers(int n) {
        if (n <= 1) return n;

        if (!numbers.contains(n)) {
            numbers.add(n);

            if (n < 3) return 1;
            if ((n & 1) == 0) {
                // even
                distinctIntegers(n - 1);
            } else {
                // odd
                n--;
                for (int i = 1; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        distinctIntegers(i);
                        if (n / i != i) {
                            distinctIntegers(n / i);
                        }
                    }
                }
            }
        }

        return numbers.size();
    }
}
