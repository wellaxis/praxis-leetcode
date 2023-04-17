package com.witalis.praxis.leetcode.task.h15.p1431.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 1431
 * Name: Kids With the Greatest Number of Candies
 * URL: <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/">Kids With the Greatest Number of Candies</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] candies;
    private int extraCandies;

    public List<Boolean> process() {
        return kidsWithCandies(candies, extraCandies);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || extraCandies < 0) return Collections.emptyList();

        final int n = candies.length;
        final int diff = Arrays.stream(candies).max().orElse(0) - extraCandies;
        final Boolean[] result = new Boolean[n];
        Arrays.fill(result, false);

        for (int i = 0; i < n; i++)
            if (candies[i] >= diff)
                result[i] = true;

        return Arrays.stream(result).toList();
    }
}
