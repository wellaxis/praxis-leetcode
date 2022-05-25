package com.witalis.praxis.leetcode.task.h14.p1399;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1399.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1399,
    description = "Count Largest Group",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, MATH}
)
public class CountLargestGroup extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    private int number;

    public static final String INFORMATION = """

        You are given an integer n.
            Each number from 1 to n is grouped according to the sum of its digits.
            Return the number of groups that have the largest size.

        Example:
            Input: n = 13
            Output: 4
            Explanation: There are 9 groups in total,
                they are grouped according sum of its digits of numbers from 1 to 13:
                [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
                There are 4 groups with largest size.""";

    public CountLargestGroup(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 814 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 639 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 631 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
