package com.witalis.praxis.leetcode.task.h8.p728;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p728.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 728,
    description = "Self Dividing Numbers",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class SelfDividingNumbers extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    private int left;
    private int right;

    public static final String INFORMATION = """

        Description:
            A self-dividing number is a number that is divisible by every digit it contains.

            For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
            A self-dividing number is not allowed to contain the digit zero.

            Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].

        Example:
            Input: left = 1, right = 22
            Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]""";

    public SelfDividingNumbers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.left = random.nextInt(1, LEN + 1);
        this.right = random.nextInt(left, LEN + 1);

        log.info("Range is [{}, {}]", left, right);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3545 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(left, right);
        return original.process();
    }

    // time = 1871 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(left, right);
        return practice.process();
    }

    // time = 2344 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(left, right);
        return solution.process();
    }
}
