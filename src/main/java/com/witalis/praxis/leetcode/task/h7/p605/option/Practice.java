package com.witalis.praxis.leetcode.task.h7.p605.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 605
 * Name: Can Place Flowers
 * URL: <a href="https://leetcode.com/problems/can-place-flowers/">Can Place Flowers</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] flowerbed;
    private int flowers;

    public Boolean process() {
        return canPlaceFlowers(flowerbed, flowers);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0 || n < 0) return false;
        if (n == 0) return true;

        int places = 1;
        for (int flower : flowerbed) {
            if (flower == 0) {
                places++;
            } else {
                n -= (places - 1) / 2;
                if (n == 0) return true;
                places = 0;
            }
        }

        return places > 0 && n - places / 2 <= 0;
    }
}
