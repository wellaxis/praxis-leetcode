package com.witalis.praxis.leetcode.task.h11.p1013.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1013
 * Name: Partition Array Into Three Parts With Equal Sum
 * URL: <a href="https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/">Partition Array Into Three Parts With Equal Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return canThreePartsEqualSum(numbers);
    }

    public boolean canThreePartsEqualSum(int[] arr) {
        if (arr == null) return false;

        final int n = arr.length;

        if (n < 3) return false;

        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) return false;

        int threshold = sum / 3;
        int partitions = 0;
        int partition = 0;
        for (int num : arr) {
            partition += num;
            if (partition == threshold) {
                partitions++;
                partition = 0;
            }
        }

        return partitions >= 3;
    }
}
