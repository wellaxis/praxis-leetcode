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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] candyTypes;

    public Integer process() {
        return distributeCandies(candyTypes);
    }

    public int distributeCandies(int[] candyType) {
        if (candyType == null || candyType.length == 0) return 0;

        Set<Integer> diffTypes = new HashSet<>();
        for (int type : candyType) diffTypes.add(type);

        return Math.min(candyType.length / 2, diffTypes.size());
    }
}
