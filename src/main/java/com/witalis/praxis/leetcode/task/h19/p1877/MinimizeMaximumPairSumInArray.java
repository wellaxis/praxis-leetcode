package com.witalis.praxis.leetcode.task.h19.p1877;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1877.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1877,
    description = "Minimize Maximum Pair Sum in Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, GREEDY, SORTING}
)
public class MinimizeMaximumPairSumInArray extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            The pair sum of a pair (a,b) is equal to a + b. The maximum pair sum is the largest pair sum in a list of pairs.

            * For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.

            Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:
                * Each element of nums is in exactly one pair, and
                * The maximum pair sum is minimized.

            Return the minimized maximum pair sum after optimally pairing up the elements.

        Example:
            Input: nums = [3,5,4,2,4,6]
            Output: 8
            Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
                The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.""";

    public MinimizeMaximumPairSumInArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, 2 * (LEN / 2)),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4637 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 4113 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 3389 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
