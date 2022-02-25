package com.witalis.praxis.leetcode.task.h3.p283.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 283
 * Name: Move Zeroes
 * URL: https://leetcode.com/problems/move-zeroes/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        moveZeroes(numbers);
        return numbers;
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int index = -1;
        int counter = 0;
        while (counter < nums.length) {
            int current = nums[counter];
            if (current == 0) {
                if (index < 0) {
                    index = counter;
                }
            } else {
                if (index >= 0) {
                    nums[index] = current;
                    index++;
                }
            }
            counter++;
        }
        if (index > 0) {
            while (index < nums.length) {
                nums[index++] = 0;
            }
        }
    }
}
