package com.witalis.praxis.leetcode.task.h9.p815;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p815.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 815,
    description = "Bus Routes",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE, BREADTH_FIRST_SEARCH}
)
public class BusRoutes extends LeetCodeTask<Integer> {
    public static final int LEN = 500;
    public static final int SIZE = 1_000;
    public static final int VALUE = 1_000;

    private int[][] routes;
    private int source;
    private int target;

    public static final String INFORMATION = """

        Description:
            You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

            * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels
              in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.

            You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target.
                You can travel between bus stops by buses only.

            Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.

        Example:
            Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
            Output: 2
            Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.""";

    public BusRoutes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.routes = new int[len][];
        for (int i = 0; i < len; i++) {
            routes[i] = random.ints(
                random.nextInt(1, SIZE + 1),
                0, VALUE
            ).distinct().toArray();
        }

        this.source = random.nextInt(0, VALUE);
        this.target = random.nextInt(0, VALUE);

        log.info("Routes: {}", Arrays.deepToString(routes));
        log.info("Source: {}", source);
        log.info("Target: {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 63753 ms
    @Override
    protected Integer original() {
        var original = new Original(routes, source, target);
        return original.process();
    }

    // time = 47205 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(routes, source, target);
        return practice.process();
    }

    // time = 6397 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(routes, source, target);
        return solution.process();
    }
}
