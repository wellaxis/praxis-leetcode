package com.witalis.praxis.leetcode.task.h5.p496.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * ID: 496
 * Name: Next Greater Element I
 * URL: <a href="https://leetcode.com/problems/next-greater-element-i/">Next Greater Element I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers1;
    private int[] numbers2;

    public int[] process() {
        return nextGreaterElement(numbers1, numbers2);
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[m];
        int[] nextGreater = new int[10000];
        Arrays.fill(nextGreater, -1);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                nextGreater[nums2[index]] = nums2[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < m; i++) {
            result[i] = nextGreater[nums1[i]];
        }

        return result;
    }
}
