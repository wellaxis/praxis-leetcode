package com.witalis.praxis.leetcode.task.h2.p179.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * ID: 179
 * Name: Largest Number
 * URL: <a href="https://leetcode.com/problems/largest-number/">Largest Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public String process() {
        return largestNumber(numbers);
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 1) return String.valueOf(nums[0]);

        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            (s1, s2) -> {
                for (int i = 0; i < s1.length() + s2.length(); i++) {
                    char c12 = i < s1.length() ? s1.charAt(i) : s2.charAt(i - s1.length());
                    char c21 = i < s2.length() ? s2.charAt(i) : s1.charAt(i - s2.length());
                    if (c12 < c21) return 1;
                    if (c12 > c21) return -1;
                }
                return 0;
            }
        );

        StringBuilder sb = new StringBuilder();

        for (int n : nums) maxHeap.add(String.valueOf(n));
        if (maxHeap.peek().equals("0")) return "0";
        while (!maxHeap.isEmpty()) sb.append(maxHeap.poll());

        return sb.toString();
    }
}
