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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<String> process() {
        return summaryRanges(numbers);
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<String> ranges = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        int index = 0;
        while (index < nums.length) {
            int value = nums[index];
            if (builder.isEmpty()) {
                builder.append(value);

                boolean range = false;
                while (index < nums.length - 1 && nums[index + 1] == value + 1) {
                    range = true;
                    index++;
                    value++;
                }
                if (range) {
                    builder.append("->").append(nums[index]);
                }

                ranges.add(builder.toString());
                builder = new StringBuilder();
            }
            index++;
        }

        return ranges;
    }
}
