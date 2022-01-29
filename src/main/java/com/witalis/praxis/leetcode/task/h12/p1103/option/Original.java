package com.witalis.praxis.leetcode.task.h12.p1103.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1103
 * Name: Distribute Candies to People
 * URL: https://leetcode.com/problems/distribute-candies-to-people/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int candies;
    private int persons;

    public int[] process() {
        return distributeCandies(candies, persons);
    }

    public int[] distributeCandies(int candies, int num_people) {
        if (candies <= 0 || num_people <= 0) return new int[0];

        int[] distribution = new int[num_people];

        int counter = 1;
        while (candies > 0) {
            if (counter >= candies) {
                distribution[(counter - 1) % num_people] += candies;
                break;
            } else {
                distribution[(counter - 1) % num_people] += counter;
                candies -= counter;
            }

            counter++;
        }

        return distribution;
    }
}
