package com.witalis.praxis.leetcode.task.h4.p303.option;

import com.witalis.praxis.leetcode.task.h4.p303.content.NumericArray;
import com.witalis.praxis.leetcode.task.h4.p303.content.NumericHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 303
 * Name: Range Sum Query - Immutable
 * URL: <a href="https://leetcode.com/problems/range-sum-query-immutable/">Range Sum Query - Immutable</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public class NumArray implements NumericArray {
        private final int[] nums;

        public NumArray(final int[] nums) {
            this.nums = nums.clone();
        }

        @Override
        public int sumRange(int left, int right) {
            if (left > right) throw new IllegalArgumentException(
                "The left index should be less or equals to right one"
            );

            int sum = 0;
            for (int i = left; i <= right; i++) sum += numbers[i];
            return sum;
        }
    }

    public List<Integer> process() {
        return NumericHandler.process(operations, new NumArray(numbers));
    }
}
