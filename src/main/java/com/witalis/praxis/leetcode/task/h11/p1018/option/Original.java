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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<Boolean> process() {
        return prefixesDivBy5(numbers);
    }

    public List<Boolean> prefixesDivBy5(int[] nums) {
        if (nums == null) return Collections.emptyList();

        final int n = nums.length;
        List<Boolean> answer = new ArrayList<>();

        int remainder = 0;
        for (int i = 0; i < n; i++) {
            remainder = (remainder * 2 + nums[i]) % 5;
            answer.add(remainder == 0);
        }

        return answer;
    }
}
