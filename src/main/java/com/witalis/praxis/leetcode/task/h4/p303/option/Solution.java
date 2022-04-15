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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public class NumArray implements NumericArray {
        private int[] array;

        public NumArray(int[] nums) {
            array = new int[nums.length];

            array[0] = nums[0];
            for (int i = 1; i < array.length; i++) {
                array[i] = array[i - 1] + nums[i];
            }
        }

        @Override
        public int sumRange(int left, int right) {
            if (left == 0) return array[right];
            return array[right] - array[left - 1];
        }
    }

    public List<Integer> process() {
        return NumericHandler.process(operations, new NumArray(numbers));
    }
}
