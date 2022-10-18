package com.witalis.praxis.leetcode.task.h4.p307.option;

import com.witalis.praxis.leetcode.task.h4.p307.content.NumericArray;
import com.witalis.praxis.leetcode.task.h4.p307.content.NumericArrayHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 307
 * Name: Range Sum Query - Mutable
 * URL: <a href="https://leetcode.com/problems/range-sum-query-mutable/">Range Sum Query - Mutable</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;
    private int[] numbers;

    public class NumArray implements NumericArray {
        int[] bits;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = new int[nums.length];
            this.bits = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                update(i, nums[i]);
            }
        }

        @Override
        public void update(int index, int val) {
            int diff = val - this.nums[index];
            nums[index] = val;

            index++;
            while (index < bits.length) {
                bits[index] += diff;
                index += index & -index;
            }
        }

        @Override
        public int sumRange(int left, int right) {
            return query(right) - query(left - 1);
        }

        private int query(int index) {
            index++;
            int sum = 0;
            while (index > 0) {
                sum += bits[index];
                index -= index & -index;
            }

            return sum;
        }
    }

    public List<Integer> process() {
        return NumericArrayHandler.process(operations, new NumArray(numbers));
    }
}
