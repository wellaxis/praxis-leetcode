package com.witalis.praxis.leetcode.task.h8.p717.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 717
 * Name: 1-bit and 2-bit Characters
 * URL: <a href="https://leetcode.com/problems/1-bit-and-2-bit-characters/">1-bit and 2-bit Characters</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] bits;

    public Boolean process() {
        return isOneBitCharacter(bits);
    }

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (; i < bits.length - 1; i++)
            if (bits[i] != 0) i++;

        return i != bits.length;
    }
}
