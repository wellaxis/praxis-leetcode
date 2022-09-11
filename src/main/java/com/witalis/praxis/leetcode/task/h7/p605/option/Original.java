package com.witalis.praxis.leetcode.task.h7.p605.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 605
 * Name: Can Place Flowers
 * URL: <a href="https://leetcode.com/problems/can-place-flowers/">Can Place Flowers</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] flowerbed;
    private int flowers;

    public Boolean process() {
        return canPlaceFlowers(flowerbed, flowers);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0 || n < 0) return false;
        if (n == 0) return true;

        boolean place = true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                place = false;
            } else {
                if (place && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    n--;
                    if (n == 0) return true;
                }
                place = !place;
            }
        }

        return false;
    }
}
