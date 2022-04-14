package com.witalis.praxis.leetcode.task.h1.p27.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 27
 * Name: Remove Element
 * URL: <a href="https://leetcode.com/problems/remove-element/">Remove Element</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int value;

    public Integer process() {
        return removeElement(numbers, value);
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int counter = 0;
        int latest = nums.length - 1;
        while (counter <= latest) {
            if (nums[counter] == val) {
                nums[counter] = nums[latest];
                latest--;
            } else {
                counter++;
            }
        }
        return counter;
    }
}
