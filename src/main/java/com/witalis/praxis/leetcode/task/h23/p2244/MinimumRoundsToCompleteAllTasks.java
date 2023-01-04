package com.witalis.praxis.leetcode.task.h23.p2244;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2244.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2244,
    description = "Minimum Rounds to Complete All Tasks",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, GREEDY, COUNTING}
)
public class MinimumRoundsToCompleteAllTasks extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;
    private int[] tasks;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
                In each round, you can complete either 2 or 3 tasks of the same difficulty level.

            Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

        Example:
            Input: tasks = [2,2,3,3,2,4,4,4,4,4]
            Output: 4
            Explanation: To complete all the tasks, a possible plan is:
                - In the first round, you complete 3 tasks of difficulty level 2.
                - In the second round, you complete 2 tasks of difficulty level 3.
                - In the third round, you complete 3 tasks of difficulty level 4.
                - In the fourth round, you complete 2 tasks of difficulty level 4.
                It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.""";

    public MinimumRoundsToCompleteAllTasks(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.tasks = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Tasks: {}", Arrays.toString(tasks));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 36580 ms
    @Override
    protected Integer original() {
        var original = new Original(tasks);
        return original.process();
    }

    // time = 31630 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(tasks);
        return practice.process();
    }

    // time = 15698 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(tasks);
        return solution.process();
    }
}
