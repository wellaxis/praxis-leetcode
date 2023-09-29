package com.witalis.praxis.leetcode.task.h11.p1018.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 1018
 * Name: Binary Prefix Divisible By 5
 * URL: <a href="https://leetcode.com/problems/binary-prefix-divisible-by-5/">Binary Prefix Divisible By 5</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<Boolean> process() {
        return prefixesDivBy5(numbers);
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        if (nums == null) return Collections.emptyList();

        List<Boolean> answer = new ArrayList<>();

        int remainder = 0;
        for (int num : nums) {
            remainder = (remainder * 2 + num) % 5;
            answer.add(remainder == 0);
        }

        return answer;
    }
}
