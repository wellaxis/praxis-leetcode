package com.witalis.praxis.leetcode.task.h14.p1319;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1319.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1319,
    description = "Number of Operations to Make Network Connected",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, GRAPH}
)
public class NumberOfOperationsToMakeNetworkConnected extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private int computers;
    private int[][] connections;

    public static final String INFORMATION = """

        Description:
            There are n computers numbered from 0 to n - 1 connected by ethernet cables connections
                forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi.
                Any computer can reach any other computer directly or indirectly through the network.

            You are given an initial computer network connections.
                You can extract certain cables between two directly connected computers,
                and place them between any pair of disconnected computers to make them directly connected.

            Return the minimum number of times you need to do this in order to make all the computers connected.
                If it is not possible, return -1.

        Example:
            Input: n = 4, connections = [[0,1],[0,2],[1,2]]
            Output: 1
            Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.""";

    public NumberOfOperationsToMakeNetworkConnected(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.computers = random.nextInt(1, LEN + 1);

        final int len = (int) Math.min((long) computers * (computers - 1) / 2L, LEN);
        this.connections = new int[len][2];

        int cable = 0;
        for (int i = 0; i < computers; i++) {
            for (int j = i + 1; j < computers; j++) {
                if (cable < len) {
                    connections[cable][0] = i;
                    connections[cable][1] = j;
                    cable++;
                }
            }
        }

        log.info("Computers: {}", computers);
        log.info("Connections: {}", Arrays.deepToString(connections));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 47756 ms
    @Override
    protected Integer original() {
        var original = new Original(computers, connections);
        return original.process();
    }

    // time = 18861 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(computers, connections);
        return practice.process();
    }

    // time = 8280 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(computers, connections);
        return solution.process();
    }
}
