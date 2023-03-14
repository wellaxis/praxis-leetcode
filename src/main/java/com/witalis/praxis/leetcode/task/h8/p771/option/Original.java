package com.witalis.praxis.leetcode.task.h8.p771.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 771
 * Name: Jewels and Stones
 * URL: <a href="https://leetcode.com/problems/jewels-and-stones/">Jewels and Stones</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String jewels;
    private String stones;

    public Integer process() {
        return numJewelsInStones(jewels, stones);
    }

    public int numJewelsInStones(String jewels, String stones) {
        if (jewels == null || stones == null) return 0;

        int count = 0;
        for (final char letter : stones.toCharArray()) {
            if (jewels.indexOf(letter) >= 0) count++;
        }

        return count;
    }
}
