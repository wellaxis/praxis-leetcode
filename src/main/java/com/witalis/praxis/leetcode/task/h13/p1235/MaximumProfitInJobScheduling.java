package com.witalis.praxis.leetcode.task.h13.p1235;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1235.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1235,
    description = "Maximum Profit in Job Scheduling",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH, DYNAMIC_PROGRAMMING, SORTING}
)
public class MaximumProfitInJobScheduling extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;
    public static final int VALUE = 1_000_000_000;
    public static final int COST = 10_000;

    private int[] startTime;
    private int[] endTime;
    private int[] profit;

    public static final String INFORMATION = """

        Description:
            We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i],
                obtaining a profit of profit[i].

            You're given the startTime, endTime and profit arrays, return the maximum profit you can take such
                that there are no two jobs in the subset with overlapping time range.

            If you choose a job that ends at time X you will be able to start another job that starts at time X.

        Example:
            Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
            Output: 150
            Explanation: The subset chosen is the first, fourth and fifth job. Profit obtained 150 = 20 + 70 + 60.""";

    public MaximumProfitInJobScheduling(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.startTime = new int[len];
        this.endTime = new int[len];
        this.profit = new int[len];

        for (int i = 0; i < len; i++) {
            int time1 = random.nextInt(1, VALUE + 1);
            int time2 = random.nextInt(1, VALUE + 1);
            startTime[i] = Math.min(time1, time2);
            endTime[i] = Math.max(time1, time2);
            profit[i] = random.nextInt(1, COST + 1);
        }

        log.info("Start time: {}", Arrays.toString(startTime));
        log.info("End time: {}", Arrays.toString(endTime));
        log.info("Profit: {}", Arrays.toString(profit));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5432 ms
    @Override
    protected Integer original() {
        var original = new Original(startTime.clone(), endTime.clone(), profit.clone());
        return original.process();
    }

    // time = 5013 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(startTime.clone(), endTime.clone(), profit.clone());
        return practice.process();
    }

    // time = 3625 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(startTime.clone(), endTime.clone(), profit.clone());
        return solution.process();
    }
}
