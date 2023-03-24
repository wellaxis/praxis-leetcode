package com.witalis.praxis.leetcode.task.h15.p1466;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1466.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1466,
    description = "Reorder Routes to Make All Paths Lead to the City Zero",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, GRAPH}
)
public class ReorderRoutesToMakeAllPathsLeadToCityZero extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;

    private int cities;
    private int[][] roads;

    public static final String INFORMATION = """

        Description:
            There are n cities numbered from 0 to n - 1 and n - 1 roads such that
                there is only one way to travel between two different cities (this network form a tree).
                Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

            Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

            This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

            Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

            It's guaranteed that each city can reach city 0 after reorder.

        Example:
            Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
            Output: 3
            Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).""";

    public ReorderRoutesToMakeAllPathsLeadToCityZero(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.cities = random.nextInt(2, LEN + 1);

        final List<Integer> towns = new ArrayList<>(IntStream.range(0, cities).boxed().toList());
        Collections.shuffle(towns);

        this.roads = new int[cities - 1][2];
        for (int i = 1; i < towns.size(); i++) {
            roads[i - 1] = new int[] {towns.get(i - 1), towns.get(i)};
        }

        log.info("Cities: {}", cities);
        log.info("Connections: {}", Arrays.deepToString(roads));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3565 ms
    @Override
    protected Integer original() {
        var original = new Original(cities, roads);
        return original.process();
    }

    // time = 2833 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cities, roads);
        return practice.process();
    }

    // time = 1716 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cities, roads);
        return solution.process();
    }
}
