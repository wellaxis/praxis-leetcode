package com.witalis.praxis.leetcode.task.h5.p461;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p461.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 461,
    description = "Hamming Distance",
    difficulty = TaskDifficulty.EASY,
    tags = {BIT_MANIPULATION}
)
public class HammingDistance extends LeetCodeTask<Integer> {
    private int number1;
    private int number2;

    public static final String INFORMATION = """

        The Hamming distance between two integers
            is the number of positions at which the corresponding bits are different.

        Given two integers x and y, return the Hamming distance between them.

        Example:
            Input: x = 1, y = 4
            Output: 2
            Explanation:
            1   (0 0 0 1)
            4   (0 1 0 0)
                   ↑   ↑
            The above arrows point to positions where the corresponding bits are different.""";

    public HammingDistance(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number1 = random.nextInt(0, Integer.MAX_VALUE);
        this.number2 = random.nextInt(0, Integer.MAX_VALUE);

        log.info("Number 'x' is {}", number1);
        log.info("Number 'y' is {}", number2);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 572 ms
    @Override
    protected Integer original() {
        var original = new Original(number1, number2);
        return original.process();
    }

    // time = 379 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number1, number2);
        return practice.process();
    }

    // time = 375 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number1, number2);
        return solution.process();
    }
}
