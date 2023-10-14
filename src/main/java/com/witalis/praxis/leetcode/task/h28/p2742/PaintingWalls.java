package com.witalis.praxis.leetcode.task.h28.p2742;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h28.p2742.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2742,
    description = "Painting the Walls",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class PaintingWalls extends LeetCodeTask<Integer> {
    public static final int LEN = 500;
    public static final int COST = 1_000_000;
    public static final int TIME = 500;

    private int[] costs;
    private int[] times;

    public static final String INFORMATION = """

        Description:
            You are given two 0-indexed integer arrays, cost and time, of size n representing the costs and the time
                taken to paint n different walls respectively. There are two painters available:
                * A paid painter that paints the ith wall in time[i] units of time and takes cost[i] units of money.
                * A free painter that paints any wall in 1 unit of time at a cost of 0.
                  But the free painter can only be used if the paid painter is already occupied.

            Return the minimum amount of money required to paint the n walls.

        Example:
            Input: cost = [1,2,3,2], time = [1,2,3,2]
            Output: 3
            Explanation: The walls at index 0 and 1 will be painted by the paid painter, and it will take 3 units of time;
                meanwhile, the free painter will paint the walls at index 2 and 3, free of cost in 2 units of time.
                Thus, the total cost is 1 + 2 = 3.""";

    public PaintingWalls(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.costs = random.ints(
            len, 1, COST + 1
        ).toArray();
        this.times = random.ints(
            len, 1, TIME + 1
        ).toArray();

        log.info("Cost: {}", Arrays.toString(costs));
        log.info("Time: {}", Arrays.toString(times));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5403 ms
    @Override
    protected Integer original() {
        var original = new Original(costs.clone(), times.clone());
        return original.process();
    }

    // time = 4844 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(costs.clone(), times.clone());
        return practice.process();
    }

    // time = 4536 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(costs.clone(), times.clone());
        return solution.process();
    }
}
