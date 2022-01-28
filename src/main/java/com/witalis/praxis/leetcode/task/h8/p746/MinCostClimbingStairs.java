package com.witalis.praxis.leetcode.task.h8.p746;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p746.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 746,
    description = "Min Cost Climbing Stairs",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class MinCostClimbingStairs extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 999;
    private int[] cost;

    public static final String INFORMATION = """

        You are given an integer array cost where cost[i]
            is the cost of ith step on a staircase.
            Once you pay the cost, you can either climb one or two steps.

        You can either start from the step with index 0,
            or the step with index 1.

        Return the minimum cost to reach the top of the floor.

        Example:
            Input: cost = [1,100,1,1,1,100,1,1,100,1]
            Output: 6
            Explanation: You will start at index 0.
            - Pay 1 and climb two steps to reach index 2.
            - Pay 1 and climb two steps to reach index 4.
            - Pay 1 and climb two steps to reach index 6.
            - Pay 1 and climb one step to reach index 7.
            - Pay 1 and climb two steps to reach index 9.
            - Pay 1 and climb one step to reach the top.
            The total cost is 6.""";

    public MinCostClimbingStairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.cost = random.ints(
            random.nextInt(2, LEN + 1),
            0,
            VALUE
        ).toArray();

        log.info("Cost is {}", cost);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 517 ms
    @Override
    protected Integer original() {
        var original = new Original(cost.clone());
        return original.process();
    }

    // time = 483 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cost.clone());
        return practice.process();
    }

    // time = 413 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cost.clone());
        return solution.process();
    }
}
