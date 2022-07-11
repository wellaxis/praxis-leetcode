package com.witalis.praxis.leetcode.task.h5.p476;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p476.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 476,
    description = "Number Complement",
    difficulty = TaskDifficulty.EASY,
    tags = {BIT_MANIPULATION}
)
public class NumberComplement extends LeetCodeTask<Integer> {
    private int number;

    public static final String INFORMATION = """

        The complement of an integer is the integer you get when you
            flip all the 0's to 1's and all the 1's to 0's in its binary representation.

        For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.

        Given an integer num, return its complement.

        Example:
            Input: num = 5
            Output: 2
            Explanation: The binary representation of 5 is 101, and its complement is 010. So you need to output 2.""";

    public NumberComplement(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, Integer.MAX_VALUE);
        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 451 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 481 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 435 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
