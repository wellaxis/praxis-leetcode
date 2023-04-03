package com.witalis.praxis.leetcode.task.h9.p881.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 881
 * Name: Boats to Save People
 * URL: <a href="https://leetcode.com/problems/boats-to-save-people/">Boats to Save People</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] people;
    private int limit;

    public Integer process() {
        return numRescueBoats(people, limit);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }

        return ans;
    }
}
