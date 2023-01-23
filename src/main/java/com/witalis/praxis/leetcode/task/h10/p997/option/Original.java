package com.witalis.praxis.leetcode.task.h10.p997.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * ID: 997
 * Name: Find the Town Judge
 * URL: <a href="https://leetcode.com/problems/find-the-town-judge/">Find the Town Judge</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int[][] trust;

    public Integer process() {
        return findJudge(number, trust);
    }

    public int findJudge(int n, int[][] trust) {
        if (n <= 0) return -1;
        if (n == 1) return 1;

        Map<Integer, Set<Integer>> trusts = new HashMap<>();

        for (int[] pair : trust) {
            trusts.putIfAbsent(pair[0], new HashSet<>());
            trusts.get(pair[0]).add(pair[1]);
        }

        int[] judges = IntStream.rangeClosed(1, n)
            .filter(i -> !trusts.containsKey(i))
            .filter(i -> trusts.values().stream().filter(set -> set.contains(i)).count() == n - 1)
            .toArray();

        return judges.length == 1 ? judges[0] : -1;
    }
}
