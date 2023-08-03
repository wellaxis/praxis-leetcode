package com.witalis.praxis.leetcode.task.h9.p868;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p868.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 868,
    description = "Binary Gap",
    difficulty = TaskDifficulty.EASY,
    tags = {BIT_MANIPULATION}
)
public class BinaryGap extends LeetCodeTask<Integer> {
    public static final int VALUE = 1_000_000_000;

    private int number;

    public static final String INFORMATION = """

        Description:
            Given a positive integer n, find and return the longest distance between
                any two adjacent 1's in the binary representation of n.
                If there are no two adjacent 1's, return 0.

            Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
                The distance between two 1's is the absolute difference between their bit positions.
                For example, the two 1's in "1001" have a distance of 3.

        Example:
            Input: n = 22
            Output: 2
            Explanation: 22 in binary is "10110".
                The first adjacent pair of 1's is "10110" with a distance of 2.
                The second adjacent pair of 1's is "10110" with a distance of 1.
                The answer is the largest of these two distances, which is 2.
                Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.""";

    public BinaryGap(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, VALUE + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 586 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 458 ms
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
