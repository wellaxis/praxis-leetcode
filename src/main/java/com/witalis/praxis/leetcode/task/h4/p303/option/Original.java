package com.witalis.praxis.leetcode.task.h4.p303.option;

import com.witalis.praxis.leetcode.task.h4.p303.content.NumericArray;
import com.witalis.praxis.leetcode.task.h4.p303.content.NumericHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 303
 * Name: Range Sum Query - Immutable
 * URL: <a href="https://leetcode.com/problems/range-sum-query-immutable/">Range Sum Query - Immutable</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public final class NumArray implements NumericArray {
        private final int[] nums;
        private boolean copy = true;

        public NumArray(final int[] nums) {
            this.nums = nums;
        }

        @Override
        public int sumRange(int left, int right) {
            if (left > right) throw new IllegalArgumentException(
                "The left index should be less or equals to right one"
            );

            return copy
                ? Arrays.stream(Arrays.copyOfRange(numbers, left, right + 1)).sum()
                : Arrays.stream(nums).skip(left).limit(right - left + 1L).sum();
        }
    }

    public List<Integer> process() {
        return NumericHandler.process(operations, new NumArray(numbers));
    }
}
