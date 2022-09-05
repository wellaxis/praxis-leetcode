package com.witalis.praxis.leetcode.task.h6.p575.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 575
 * Name: Distribute Candies
 * URL: <a href="https://leetcode.com/problems/distribute-candies/">Distribute Candies</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] candyTypes;

    public Integer process() {
        return distributeCandies(candyTypes);
    }

    public int distributeCandies(int[] candyType) {
        int maxCount = candyType.length / 2;
        Set<Integer> uniqueCount = new HashSet<>();
        for (int candy : candyType) {
            uniqueCount.add(candy);
            if (uniqueCount.size() == maxCount) return maxCount;
        }

        return uniqueCount.size();
    }
}
