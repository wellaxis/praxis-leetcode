package com.witalis.praxis.leetcode.task.h1.p89.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 89
 * Name: Gray Code
 * URL: <a href="https://leetcode.com/problems/gray-code/">Gray Code</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public List<Integer> process() {
        return grayCode(number);
    }

    public List<Integer> grayCode(int n) {
        if (n < 0) return Collections.emptyList();
        if (n == 0) return List.of(0);

        List<Integer> sub = grayCode(n - 1);
        List<Integer> numbers = new ArrayList<>(sub);

        int num = 1 << (n - 1);
        for (int i = sub.size() - 1; i >= 0; i--) {
            numbers.add(num + sub.get(i));
        }

        return numbers;
    }
}
