package com.witalis.praxis.leetcode.task.h15.p1431.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1431
 * Name: Kids With the Greatest Number of Candies
 * URL: <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">Kids With the Greatest Number of Candies</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] candies;
    private int extraCandies;

    public List<Boolean> process() {
        return kidsWithCandies(candies, extraCandies);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find out the greatest number of candies among all the kids
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(candy, maxCandies);
        }

        // for each kid, check if they will have the greatest number of candies among all the kids
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}
