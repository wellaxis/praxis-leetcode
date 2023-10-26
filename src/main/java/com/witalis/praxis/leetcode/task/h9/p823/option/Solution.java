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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] array;

    public Integer process() {
        return numFactoredBinaryTrees(array);
    }

    public static final int mod = (int) 1e9 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);

        Map<Integer, Long> map = new HashMap<>(arr.length * 4);

        int ans = 0;
        for (int x : arr) {
            long ways = 1;

            int max = (int) Math.sqrt(x);
            for (int j = 0, left = arr[0]; left <= max; left = arr[++j]) {
                if (x % left != 0) continue;
                int right = x / left;
                if (map.containsKey(right))
                    ways = (ways + map.get(left) * map.get(right) * (left == right ? 1 : 2)) % mod;
            }

            map.put(x, ways);
            ans = (int) ((ans + ways) % mod);
        }

        return ans;
    }
}
