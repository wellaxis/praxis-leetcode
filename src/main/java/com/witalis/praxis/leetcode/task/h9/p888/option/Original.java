package com.witalis.praxis.leetcode.task.h9.p888.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 888
 * Name: Fair Candy Swap
 * URL: <a href="https://leetcode.com/problems/fair-candy-swap/">Fair Candy Swap</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] aliceSizes;
    private int[] bobSizes;

    public int[] process() {
        return fairCandySwap(aliceSizes, bobSizes);
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        if (aliceSizes == null || bobSizes == null) return new int[0];

        int aliceCandies = Arrays.stream(aliceSizes).sum();
        int bobCandies = Arrays.stream(bobSizes).sum();

        int difference = aliceCandies - bobCandies;
        if (difference % 2 != 0) return new int[0];

        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);

        int delta = difference >> 1;

        if (difference >= 0) {
            return candySwap(aliceSizes, bobSizes, delta);
        } else {
            int[] reverse = candySwap(bobSizes, aliceSizes, -delta);
            if (reverse != null) {
                return new int[] {reverse[1], reverse[0]};
            }
        }

        return new int[0];
    }

    private int[] candySwap(int[] moreSizes, int[] lessSizes, int delta) {
        int moreLen = moreSizes.length;

        int index = 0;
        while (index < moreLen && moreSizes[index] < delta) index++;

        for (int i = index; i < moreLen; i++) {
            int diff = moreSizes[i] - delta;

            if (Arrays.binarySearch(lessSizes, diff) >= 0) {
                return new int[] {moreSizes[i], diff};
            }
        }

        return null;
    }
}
