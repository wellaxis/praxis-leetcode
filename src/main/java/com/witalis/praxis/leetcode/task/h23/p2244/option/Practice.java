package com.witalis.praxis.leetcode.task.h23.p2244.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 2244
 * Name: Minimum Rounds to Complete All Tasks
 * URL: <a href="https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/">Minimum Rounds to Complete All Tasks</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] tasks;

    public Integer process() {
        return minimumRounds(tasks);
    }

    public int minimumRounds(int[] tasks) {
        if (tasks == null) return -1;

        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int task : tasks)
            frequencies.put(task, frequencies.getOrDefault(task, 0) + 1);

        int rounds = 0;
        for (final int frequency : frequencies.values()) {
            if (frequency == 1) return -1;
            rounds += frequency / 3 + ((frequency % 3 == 0) ? 0 : 1);
        }

        return rounds;
    }
}
