package com.witalis.praxis.leetcode.task.h3.p228.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 228
 * Name: Summary Ranges
 * URL: https://leetcode.com/problems/summary-ranges/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public List<String> process() {
        return summaryRanges(numbers);
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<String> ranges = new ArrayList<>();
        StringBuilder range;

        int index = 0;
        while (index < nums.length) {
            int value = nums[index];
            range = new StringBuilder();
            range.append(value);

            boolean isRange = false;
            while (index < nums.length - 1 && nums[index + 1] == value + 1) {
                isRange = true;
                index++;
                value++;
            }
            if (isRange) range.append("->").append(nums[index]);

            ranges.add(range.toString());
            index++;
        }

        return ranges;
    }
}
