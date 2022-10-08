package com.witalis.praxis.leetcode.task.h3.p287.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 287
 * Name: Find the Duplicate Number
 * URL: <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return findDuplicate(numbers);
    }

    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        int n = nums.length - 1;
        int maxNum = findMaxNum(nums);
        int maxBit = calcMaxBit(maxNum);

        // iterate over each bit
        for (int bit = 0; bit < maxBit; bit++) {
            int mask = (1 << bit);
            int baseCount = 0;
            int numsCount = 0;

            for (int i = 0; i <= n; i++) {
                // if bit is set in number (i) then add 1 to base_count
                if ((i & mask) > 0) baseCount++;
                // if bit is set in nums[i] then add 1 to nums_count
                if ((nums[i] & mask) > 0) numsCount++;
            }

            // if the current bit is more frequently set in nums than it is in
            // the range [1, 2, ..., n] then it must also be set in the duplicate number
            if (numsCount > baseCount) {
                duplicate |= mask;
            }
        }

        return duplicate;
    }

    // find the position of the most significant bit in num
    private int calcMaxBit(int num) {
        int bits = 0;
        while (num > 0) {
            num /= 2;
            bits++;
        }

        return bits;
    }

    // find the largest number in nums
    private int findMaxNum(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);

        return max;
    }
}
