package com.witalis.praxis.leetcode.task.h11.p1009;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1009.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1009,
    description = "Complement of Base 10 Integer",
    difficulty = TaskDifficulty.EASY,
    tags = {BIT_MANIPULATION}
)
public class ComplementOfBase10Integer extends LeetCodeTask<Integer> {
    public static final int VALUE = (int) 1e9;

    private int number;

    public static final String INFORMATION = """

        Description:
            The complement of an integer is the integer you get when you flip
                all the 0's to 1's and all the 1's to 0's in its binary representation.

            * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.

            Given an integer n, return its complement.

        Example:
            Input: n = 5
            Output: 2
            Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.""";

    public ComplementOfBase10Integer(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, VALUE + 1);

        log.info("Number 'n': {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 626 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 487 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 412 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
