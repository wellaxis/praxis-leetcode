package com.witalis.praxis.leetcode.task.h22.p2141;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h22.p2141.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2141,
    description = "Maximum Running Time of N Computers",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH, GREEDY, SORTING}
)
public class MaximumRunningTimeOfNComputers extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int computers;
    private int[] batteries;

    public static final String INFORMATION = """

        Description:
            You have n computers. You are given the integer n and a 0-indexed integer array batteries
                where the i^th battery can run a computer for batteries[i] minutes.
                You are interested in running all n computers simultaneously using the given batteries.

            Initially, you can insert at most one battery into each computer. After that and at any integer time moment,
                you can remove a battery from a computer and insert another battery any number of times.
                The inserted battery can be a totally new battery or a battery from another computer.
                You may assume that the removing and inserting processes take no time.

            Note that the batteries cannot be recharged.

            Return the maximum number of minutes you can run all the n computers simultaneously.

        Example:
            Input: n = 2, batteries = [3,3,3]
            Output: 4
            Explanation:
                Initially, insert battery 0 into the first computer and battery 1 into the second computer.
                After two minutes, remove battery 1 from the second computer and insert battery 2 instead. Note that battery 1 can still run for one minute.
                At the end of the third minute, battery 0 is drained, and you need to remove it from the first computer and insert battery 1 instead.
                By the end of the fourth minute, battery 1 is also drained, and the first computer is no longer running.
                We can run the two computers simultaneously for at most 4 minutes, so we return 4.""";

    public MaximumRunningTimeOfNComputers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.computers = random.nextInt(1, LEN + 1);
        this.batteries = random.ints(
            random.nextInt(computers, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Computers N: {}", computers);
        log.info("Batteries: {}", Arrays.toString(batteries));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 15085 ms
    @Override
    protected Long original() {
        var original = new Original(computers, batteries.clone());
        return original.process();
    }

    // time = 13091 ms
    @Override
    protected Long practice() {
        var practice = new Practice(computers, batteries.clone());
        return practice.process();
    }

    // time = 7768 ms
    @Override
    protected Long solution() {
        var solution = new Solution(computers, batteries.clone());
        return solution.process();
    }
}
