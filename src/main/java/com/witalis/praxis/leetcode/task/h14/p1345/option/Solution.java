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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return minJumps(numbers);
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.computeIfAbsent(arr[i], k -> new ArrayList<>());
            list.add(i);
        }

        Deque<Integer> forward = new LinkedList<>();
        Deque<Integer> backward = new LinkedList<>();

        int[] visited = new int[n];

        visited[0] = 1;
        forward.add(0);

        visited[n - 1] = 2;
        backward.add(n - 1);

        for (int res = 1, dir = 1; ; res++) {
            if (forward.size() > backward.size()) {
                Deque<Integer> temp = forward;
                forward = backward;
                backward = temp;
                dir = 3 - dir;
            }
            for (int size = forward.size(); size-- > 0; ) {
                int i = forward.poll();
                List<Integer> list = map.get(arr[i]);
                if (i - 1 >= 0) list.add(i - 1);
                if (i + 1 < n) list.add(i + 1);
                for (int j : list) {
                    if (visited[j] == 0) {
                        visited[j] = dir;
                        forward.add(j);
                    } else if (visited[j] != dir) return res;
                }
                list.clear();
            }
        }
    }
}
