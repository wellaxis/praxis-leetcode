package com.witalis.praxis.leetcode.task.h15.p1470.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1470
 * Name: Shuffle the Array
 * URL: <a href="https://leetcode.com/problems/shuffle-the-array/">Shuffle the Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int number;

    public int[] process() {
        return shuffle(numbers, number);
    }

    public int[] shuffle(int[] nums, int n) {
        // store each y(i) with respective x(i).
        for (int i = n; i < 2 * n; ++i) {
            int secondNum = nums[i] << 10;
            nums[i - n] |= secondNum;
        }

        // '0000000000 1111111111' in decimal.
        int allOnes = (int) Math.pow(2, 10) - 1;

        // we will start putting all numbers from the end, as they are empty places.
        for (int i = n - 1; i >= 0; --i) {
            // fetch both the numbers from the current index.
            int secondNum = nums[i] >> 10;
            int firstNum = nums[i] & allOnes;
            nums[2 * i + 1] = secondNum;
            nums[2 * i] = firstNum;
        }
        return nums;
    }
}
