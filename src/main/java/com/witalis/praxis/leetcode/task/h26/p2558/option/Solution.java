package com.witalis.praxis.leetcode.task.h26.p2558.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2558
 * Name: Take Gifts From the Richest Pile
 * URL: <a href="https://leetcode.com/problems/take-gifts-from-the-richest-pile/">Take Gifts From the Richest Pile</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] gifts;
    private int seconds;

    public Long process() {
        return pickGifts(gifts, seconds);
    }

    public long pickGifts(int[] gifts, int k) {
        int len = gifts.length;
        int i = 0;
        while (k > 0) {
            if (i != -1) Arrays.sort(gifts);
            int stop = (int) Math.floor(Math.sqrt(gifts[len - 1]));
            if (gifts[len - 1] == 1) break;
            for (i = len - 1; i >= 0 && k > 0; i--) {
                if (gifts[i] >= stop) {
                    gifts[i] = (int) Math.floor(Math.sqrt(gifts[i]));
                    k--;
                } else break;
            }
        }

        long sum = 0;
        for (int gift : gifts) sum += gift;

        return sum;
    }
}
