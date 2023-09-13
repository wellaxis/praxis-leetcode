package com.witalis.praxis.leetcode.task.h2.p135.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 135
 * Name: Candy
 * URL: <a href="https://leetcode.com/problems/candy/">Candy</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] ratings;

    public Integer process() {
        return candy(ratings);
    }

    public int candy(int[] ratings) {
        if (ratings == null) return 0;

        int candies = 0;

        final int n = ratings.length;

        int[] distribution = new int[n + 1];
        Arrays.fill(distribution, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                distribution[i] = distribution[i - 1] + 1;
            }
        }

        int adjunct = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                adjunct++;
                distribution[i] = Math.max(adjunct, distribution[i]);
            } else {
                adjunct = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            candies += distribution[i];
        }

        return candies;
    }
}
