package com.witalis.praxis.leetcode.task.h29.p2815.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * ID: 2815
 * Name: Max Pair Sum in an Array
 * URL: <a href="https://leetcode.com/problems/max-pair-sum-in-an-array/">Max Pair Sum in an Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return maxSum(numbers);
    }

    public int maxSum(int[] nums) {
        if (nums == null) return -1;

        Map<Integer, Queue<Integer>> heaps = new HashMap<>();
        IntStream.rangeClosed(1, 9).forEach(i -> heaps.put(i, new PriorityQueue<>(Comparator.reverseOrder())));

        for (int num : nums) {
            switch (maxDigit(num)) {
                case 9 -> heaps.get(9).offer(num);
                case 8 -> heaps.get(8).offer(num);
                case 7 -> heaps.get(7).offer(num);
                case 6 -> heaps.get(6).offer(num);
                case 5 -> heaps.get(5).offer(num);
                case 4 -> heaps.get(4).offer(num);
                case 3 -> heaps.get(3).offer(num);
                case 2 -> heaps.get(2).offer(num);
                case 1 -> heaps.get(1).offer(num);
                default -> {}
            }
        }

        AtomicInteger sum = new AtomicInteger(-1);
        heaps.values().forEach(
            heap -> {
                if (heap.size() > 1) {
                    sum.set(Math.max(sum.get(), heap.poll() + heap.poll()));
                }
            }
        );

        return sum.get();
    }

    private int maxDigit(int num) {
        if (String.valueOf(num).contains("9")) return 9;
        if (String.valueOf(num).contains("8")) return 8;
        if (String.valueOf(num).contains("7")) return 7;
        if (String.valueOf(num).contains("6")) return 6;
        if (String.valueOf(num).contains("5")) return 5;
        if (String.valueOf(num).contains("4")) return 4;
        if (String.valueOf(num).contains("3")) return 3;
        if (String.valueOf(num).contains("2")) return 2;
        if (String.valueOf(num).contains("1")) return 1;

        return 0;
    }
}
