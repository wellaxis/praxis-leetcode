package com.witalis.praxis.leetcode.task.h9.p823.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 823
 * Name: Binary Trees With Factors
 * URL: <a href="https://leetcode.com/problems/binary-trees-with-factors/">Binary Trees With Factors</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] array;

    public Integer process() {
        return numFactoredBinaryTrees(array);
    }

    public static final int MOD = (int) 1e9 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        if (arr == null) return 0;

        Arrays.sort(arr);

        Map<Integer, Long> dp = new HashMap<>();

        long count = 0L;

        for (int x : arr) {
            int sqrt = (int) Math.sqrt(x);

            dp.put(x, 1L);
            for (int i = 0; arr[i] <= sqrt; i++) {
                int y = arr[i];

                if (x % y == 0) {
                    int z = x / y;
                    int c = (y == z) ? 1 : 2;
                    if (dp.containsKey(z))
                        dp.put(x, (dp.get(x) + dp.get(y) * dp.get(z) * c) % MOD);
                }
            }

            count = (count + dp.get(x)) % MOD;
        }

        return (int) count;
    }
}
