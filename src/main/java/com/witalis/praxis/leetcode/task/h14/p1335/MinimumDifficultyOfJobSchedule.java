package com.witalis.praxis.leetcode.task.h14.p1335;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1335.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1335,
    description = "Minimum Difficulty of a Job Schedule",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class MinimumDifficultyOfJobSchedule extends LeetCodeTask<Integer> {
    public static final int LEN = 300;
    public static final int VALUE = 1_000;
    public static final int PERIOD = 10;

    private int[] jobDifficulty;
    private int days;

    public static final String INFORMATION = """

        Description:
            You want to schedule a list of jobs in d days.
                Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).

            You have to finish at least one task every day.
                The difficulty of a job schedule is the sum of difficulties of each day of the d days.
                The difficulty of a day is the maximum difficulty of a job done on that day.

            You are given an integer array jobDifficulty and an integer d.
                The difficulty of the ith job is jobDifficulty[i].

            Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.

        Example:
            Input: jobDifficulty = [6,5,4,3,2,1], d = 2
            Output: 7
            Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
                Second day you can finish the last job, total difficulty = 1.
                The difficulty of the schedule = 6 + 1 = 7""";

    public MinimumDifficultyOfJobSchedule(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.jobDifficulty = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();
        this.days = random.nextInt(1, PERIOD + 1);

        log.info("Job Difficulty: {}", Arrays.toString(jobDifficulty));
        log.info("Days 'd': {}", days);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1678 ms
    @Override
    protected Integer original() {
        var original = new Original(jobDifficulty, days);
        return original.process();
    }

    // time = 1667 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(jobDifficulty, days);
        return practice.process();
    }

    // time = 1302 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(jobDifficulty, days);
        return solution.process();
    }
}
