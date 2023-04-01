package com.witalis.praxis.leetcode.task.h10.p976.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 976
 * Name: Largest Perimeter Triangle
 * URL: <a href="https://leetcode.com/problems/largest-perimeter-triangle/">Largest Perimeter Triangle</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return largestPerimeter(numbers);
    }

    public int largestPerimeter(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int perimeter = 0;
        Arrays.sort(nums);

        final int n = nums.length;
        final int[] sides = new int[3];
        sides[0] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            final int num = nums[i];
            if (sides[1] == 0) {
                if (num > sides[0] / 2) {
                    sides[1] = num;
                } else {
                    sides[0] = num;
                }
            } else {
                if (num + sides[1] > sides[0]) {
                    return num + sides[1] + sides[0];
                } else {
                    sides[0] = sides[1];
                    sides[1] = 0;
                    if (num > sides[0] / 2) {
                        sides[1] = num;
                    } else {
                        sides[0] = num;
                    }
                }
            }
        }

        return perimeter;
    }
}
