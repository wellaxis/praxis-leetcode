package com.witalis.praxis.leetcode.task.h12.p1103.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1103
 * Name: Distribute Candies to People
 * URL: <a href="https://leetcode.com/problems/distribute-candies-to-people/">Distribute Candies to People</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int candies;
    private int persons;

    public int[] process() {
        return distributeCandies(candies, persons);
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];

        int give = 1;
        while (candies > 0) {
            result[(give - 1) % num_people] += Math.min(give, candies);
            candies -= give;
            give++;
        }

        return result;
    }
}
