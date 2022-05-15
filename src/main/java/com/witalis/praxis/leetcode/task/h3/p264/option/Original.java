package com.witalis.praxis.leetcode.task.h3.p264.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 264
 * Name: Ugly Number II
 * URL: <a href="https://leetcode.com/problems/ugly-number-ii/">Ugly Number II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return nthUglyNumber(number);
    }

    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        List<Integer> numbers = new ArrayList<>(List.of(1));

        int f2 = 0;
        int f3 = 0;
        int f5 = 0;

        for (int i = 1; i < n; i++) {
            int f2Ugly = numbers.get(f2) * 2;
            int f3Ugly = numbers.get(f3) * 3;
            int f5Ugly = numbers.get(f5) * 5;

            int min = Math.min(Math.min(f2Ugly, f3Ugly), f5Ugly);

            if (min == f2Ugly) f2++;
            if (min == f3Ugly) f3++;
            if (min == f5Ugly) f5++;

            numbers.add(min);
        }

        return numbers.get(numbers.size() - 1);
    }
}
