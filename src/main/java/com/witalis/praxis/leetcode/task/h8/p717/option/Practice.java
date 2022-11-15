package com.witalis.praxis.leetcode.task.h8.p717.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 717
 * Name: 1-bit and 2-bit Characters
 * URL: <a href="https://leetcode.com/problems/1-bit-and-2-bit-characters/">1-bit and 2-bit Characters</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] bits;

    public Boolean process() {
        return isOneBitCharacter(bits);
    }

    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null) return false;

        int len = bits.length;
        if (len == 0 || bits[len - 1] != 0) return false;

        int index = 0;
        while (index < len) {
            if (index == len - 1) return true;
            index += bits[index] == 1 ? 2 : 1;
        }

        return false;
    }
}
