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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;
    private int[] numbers;

    public class NumArray implements NumericArray {
        private final int[] nums;
        private int sum;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.sum = 0;
            for (int num : nums) sum += num;
        }

        @Override
        public void update(int index, int val) {
            sum += val - nums[index];
            nums[index] = val;
        }

        @Override
        public int sumRange(int left, int right) {
            int sums = 0;
            if (right - left <= nums.length / 2) {
                while (left <= right) sums += nums[left++];
            } else {
                int leftSum = 0;
                while (--left >= 0) leftSum += nums[left];
                int rightSum = 0;
                while (++right < nums.length) rightSum += nums[right];

                sums = sum - (leftSum + rightSum);
            }
            return sums;
        }
    }

    public List<Integer> process() {
        return NumericArrayHandler.process(operations, new NumArray(numbers));
    }
}
