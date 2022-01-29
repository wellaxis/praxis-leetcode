package com.witalis.praxis.leetcode.task.h8.p703.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ID: 703
 * Name: Kth Largest Element in a Stream
 * URL: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int k;
    private int[] numbers;
    private int[] extra;

    public Integer process() {
        KthLargest kthLargest = new KthLargest(k, numbers);
        return kthLargestScenario(kthLargest, extra);
    }

    class KthLargest {
        private final int k;
        private final List<Integer> nums;

        public KthLargest(int k, int[] nums) {
            if (k > nums.length) {
                throw new IllegalArgumentException("Lack of elements in array for Kth largest search");
            }

            this.k = k;
            this.nums = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        }

        public int add(int val) {
            nums.add(val);
            nums.sort(Comparator.reverseOrder());
            return nums.get(k - 1);
        }
    }

    public int kthLargestScenario(KthLargest kthLargest, int[] extra) {
        if (kthLargest == null || extra == null) return 0;

        AtomicInteger kth = new AtomicInteger();
        Arrays.stream(extra).forEach(
            element -> kth.set(kthLargest.add(element))
        );

        return kth.get();
    }
}
