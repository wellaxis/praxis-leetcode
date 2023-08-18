package com.witalis.praxis.leetcode.task.h17.p1615;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1615.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1615,
    description = "Maximal Network Rank",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {GRAPH}
)
public class MaximalNetworkRank extends LeetCodeTask<Integer> {
    public static final int SIZE = 100;

    private int cities;
    private int[][] roads;

    public static final String INFORMATION = """

        Description:
            There is an infrastructure of n cities with some number of roads connecting these cities.
                Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

            The network rank of two different cities is defined as the total number of directly connected roads to either city.
                If a road is directly connected to both cities, it is only counted once.

            The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

            Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.

        Example:
            Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
            Output: 5
            Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do not have to be connected.""";

    public MaximalNetworkRank(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.cities = random.nextInt(2, SIZE + 1);
        int len = random.nextInt(0, cities * (cities - 1) / 2);
        this.roads = new int[len][2];
        for (int i = 0; i < len; i++) {
            roads[i] = new int[] {
                random.nextInt(0, cities),
                random.nextInt(0, cities)
            };
        }

        log.info("Cities: {}", cities);
        log.info("Roads: {}", Arrays.deepToString(roads));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 760 ms
    @Override
    protected Integer original() {
        var original = new Original(cities, roads);
        return original.process();
    }

    // time = 724 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cities, roads);
        return practice.process();
    }

    // time = 1815 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cities, roads);
        return solution.process();
    }
}
