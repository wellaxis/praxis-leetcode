package com.witalis.praxis.leetcode.task.h25.p2462;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2462.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2462,
    description = "Total Cost to Hire K Workers",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, HEAP, SIMULATION}
)
public class TotalCostToHireKWorkers extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[] costs;
    private int workers;
    private int candidates;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

            You are also given two integers k and candidates.
                We want to hire exactly k workers according to the following rules:
                * You will run k sessions and hire exactly one worker in each session.
                * In each hiring session, choose the worker with the lowest cost from either
                  the first candidates workers or the last candidates workers. Break the tie by the smallest index.
                  ** For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session,
                      we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
                  ** In the second hiring session, we will choose 1st worker because they have the same lowest cost
                     as 4th worker but they have the smallest index [3,2,7,7,2].
                     Please note that the indexing may be changed in the process.
                * If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them.
                  Break the tie by the smallest index.
                * A worker can only be chosen once.

            Return the total cost to hire exactly k workers.

        Example:
            Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
            Output: 11
            Explanation: We hire 3 workers in total. The total cost is initially 0.
            - In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8].
              The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
            - In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8].
              The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
            - In the third hiring round we choose the worker from [17,12,10,7,11,20,8].
              The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11.
              Notice that the worker with index 3 was common in the first and last four workers.
            The total hiring cost is 11.""";

    public TotalCostToHireKWorkers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);
        this.costs = random.ints(len, 1, VALUE + 1).toArray();
        this.workers = random.nextInt(1, len);
        this.candidates = random.nextInt(1, len);

        log.info("Costs: {}", Arrays.toString(costs));
        log.info("Workers K: {}", workers);
        log.info("Candidates: {}", candidates);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 867 ms
    @Override
    protected Long original() {
        var original = new Original(costs.clone(), workers, candidates);
        return original.process();
    }

    // time = 662 ms
    @Override
    protected Long practice() {
        var practice = new Practice(costs.clone(), workers, candidates);
        return practice.process();
    }

    // time = 644 ms
    @Override
    protected Long solution() {
        var solution = new Solution(costs.clone(), workers, candidates);
        return solution.process();
    }
}
