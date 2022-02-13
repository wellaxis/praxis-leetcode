package com.witalis.praxis.leetcode.task.h1.p42.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 42
 * Name: Trapping Rain Water
 * URL: https://leetcode.com/problems/trapping-rain-water/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] height;

    public Integer process() {
        return trap(height);
    }

    public int trap(int[] height) {
        // to store the total amount of rain water trapped
        int result = 0;

        // indices to traverse the array
        int left = 0;
        int right = height.length - 1;

        // to store left max and right max for two pointers left and right
        int maxL = 0;
        int maxR = 0;

        while (left <= right) {

            // we need check for minimum of left and right max for each element
            if (maxR <= maxL) {

                // add the difference between current value and right max at index r
                result += Math.max(0, maxR - height[right]);

                // update right max
                maxR = Math.max(maxR, height[right]);

                // update right pointer
                right -= 1;
            } else {

                // add the difference between current value and left max at index l
                result += Math.max(0, maxL - height[left]);

                // update left max
                maxL = Math.max(maxL, height[left]);

                // update left pointer
                left += 1;
            }
        }

        return result;
    }
}
