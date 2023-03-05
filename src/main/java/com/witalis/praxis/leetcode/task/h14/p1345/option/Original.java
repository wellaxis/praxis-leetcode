package com.witalis.praxis.leetcode.task.h14.p1345.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1345
 * Name: Jump Game IV
 * URL: <a href="https://leetcode.com/problems/jump-game-iv/">Jump Game IV</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return minJumps(numbers);
    }

    public int minJumps(int[] arr) {
        if (arr == null) return -1;

        int n = arr.length;

        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cache.putIfAbsent(arr[i], new ArrayList<>());
            cache.get(arr[i]).add(i);
        }

        boolean[] seen = new boolean[n];
        seen[0] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        int jumps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == n - 1) return jumps;

                List<Integer> indices = cache.get(arr[current]);
                indices.add(current + 1);
                indices.add(current - 1);
                for (int index : indices) {
                    if (index >= 0 && index < n && !seen[index]) {
                        seen[index] = true;
                        queue.add(index);
                    }
                }
                indices.clear();
            }
            jumps++;
        }

        return -1;
    }
}
