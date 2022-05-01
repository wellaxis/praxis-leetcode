package com.witalis.praxis.leetcode.task.h7.p650.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 650
 * Name: 2 Keys Keyboard
 * URL: <a href="https://leetcode.com/problems/2-keys-keyboard/">2 Keys Keyboard</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return minSteps(number);
    }

    public int minSteps(int n) {
        if (n <= 1) return 0;

        List<Integer> factors = new ArrayList<>();
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    factors.add(i);
                    n /= i;
                    i = 1;
                }
            }
        }

        return factors.stream().mapToInt(Integer::intValue).sum();
    }
}
