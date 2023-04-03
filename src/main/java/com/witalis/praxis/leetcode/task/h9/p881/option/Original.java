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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] people;
    private int limit;

    public Integer process() {
        return numRescueBoats(people, limit);
    }

    public int numRescueBoats(int[] people, int limit) {
        if (people == null || limit <= 0) return 0;

        int count = 0;

        Arrays.sort(people);

        final int n = people.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            if (people[low] + people[high] <= limit) {
                low++;
                high--;
            } else {
                high--;
            }
            count++;
        }

        return count;
    }
}
