package com.witalis.praxis.leetcode.task.h14.p1399.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1399
 * Name: Count Largest Group
 * URL: <a href="https://leetcode.com/problems/count-largest-group/">Count Largest Group</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return countLargestGroup(number);
    }

    public int countLargestGroup(int n) {
        if (n <= 0) return 0;

        int size = 9 * (int) (Math.log10(n) + 1) + 1;
        int[] groups = new int[size];

        for (int i = 1; i <= n; i++) {
            int sum = sumDigits(i);
            groups[sum]++;
        }

        Arrays.sort(groups);

        int count = 0;
        int max = groups[size - 1];
        for (int i = size - 1; i > 0; i--) {
            if (groups[i] == max) count++; else break;
        }

        return count;
    }

    private static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
