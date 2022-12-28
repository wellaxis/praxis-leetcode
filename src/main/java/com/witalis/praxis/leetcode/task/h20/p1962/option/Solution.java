package com.witalis.praxis.leetcode.task.h20.p1962.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * ID: 1962
 * Name: Remove Stones to Minimize the Total
 * URL: <a href="https://leetcode.com/problems/remove-stones-to-minimize-the-total/">Remove Stones to Minimize the Total</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] piles;
    private int operations;

    public Integer process() {
        return minStoneSum(piles, operations);
    }

    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        int[] array = new int[10001];

        for (int i : piles) {
            sum += i;
            array[i]++;
        }

        for (int i = 10000; i > 0 && k > 0; i--) {
            if (array[i] > 0) {
                int b = i / 2;
                sum -= Math.min(k, array[i]) * b;
                array[i - i / 2] += array[i];
                k -= array[i];
            }
        }

        return sum;
    }
}
