package com.witalis.praxis.leetcode.task.h4.p377;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p377.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 377,
    description = "Combination Sum IV",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class CombinationSumIV extends LeetCodeTask<Integer> {
    public static final int LEN = 200;
    public static final int VALUE = 1_000;

    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Description:
            Given an array of distinct integers nums and a target integer target,
                return the number of possible combinations that add up to target.

            The test cases are generated so that the answer can fit in a 32-bit integer.

        Example:
            Input: nums = [1,2,3], target = 4
            Output: 7
            Explanation:
                The possible combination ways are:
                    (1, 1, 1, 1)
                    (1, 1, 2)
                    (1, 2, 1)
                    (1, 3)
                    (2, 1, 1)
                    (2, 2)
                    (3, 1)
                Note that different sequences are counted as different combinations.""";

    public CombinationSumIV(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).distinct().toArray();
        this.target = random.nextInt(1, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Target: {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 970 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), target);
        return original.process();
    }

    // time = 822 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), target);
        return practice.process();
    }

    // time = 603 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), target);
        return solution.process();
    }
}
