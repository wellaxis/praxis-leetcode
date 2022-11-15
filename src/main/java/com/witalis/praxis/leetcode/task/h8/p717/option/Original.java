package com.witalis.praxis.leetcode.task.h8.p717.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 717
 * Name: 1-bit and 2-bit Characters
 * URL: <a href="https://leetcode.com/problems/1-bit-and-2-bit-characters/">1-bit and 2-bit Characters</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] bits;

    public Boolean process() {
        return isOneBitCharacter(bits);
    }

    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) return false;
        if (bits[bits.length - 1] != 0) return false;

        int index = 0;
        while (index < bits.length) {
            if (index == bits.length - 1) return true;
            if (bits[index] == 1) index++;
            index++;
        }

        return false;
    }
}
