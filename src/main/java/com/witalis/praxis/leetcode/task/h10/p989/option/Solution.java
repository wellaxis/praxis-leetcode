package com.witalis.praxis.leetcode.task.h10.p989.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * ID: 989
 * Name: Add to Array-Form of Integer
 * URL: <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">Add to Array-Form of Integer</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int summand;

    public List<Integer> process() {
        return addToArrayForm(numbers, summand);
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        final LinkedList<Integer> result = new LinkedList<>();

        int len = num.length - 1;
        while (len >= 0 || k != 0) {
            if (len >= 0) {
                k += num[len--];
            }

            result.addFirst(k % 10);
            k /= 10;
        }

        return result;
    }
}
