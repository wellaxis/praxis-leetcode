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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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
        int lessLen = lessSizes.length;

        int index = 0;
        while (index < moreLen && moreSizes[index] < delta) index++;

        int start = 0;
        for (int i = index; i < moreLen; i++) {
            int diff = moreSizes[i] - delta;

            int low = start;
            int high = lessLen - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int value = lessSizes[mid];

                if (value < diff) {
                    start = low;
                    low = mid + 1;
                } else if (value > diff) {
                    high = mid - 1;
                } else {
                    return new int[] {moreSizes[i], diff};
                }
            }
        }

        return null;
    }
}
