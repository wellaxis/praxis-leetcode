package com.witalis.praxis.leetcode.task.h15.p1431.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 1431
 * Name: Kids With the Greatest Number of Candies
 * URL: <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">Kids With the Greatest Number of Candies</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] candies;
    private int extraCandies;

    public List<Boolean> process() {
        return kidsWithCandies(candies, extraCandies);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || extraCandies < 0) return Collections.emptyList();

        final int n = candies.length;
        int max = 0;
        for (final int candy : candies)
            if (candy > max)
                max = candy;
        final int diff = max - extraCandies;

        final List<Boolean> result = new ArrayList<>(n);
        for (final int candy : candies)
            result.add(candy >= diff);

        return result;
    }
}
