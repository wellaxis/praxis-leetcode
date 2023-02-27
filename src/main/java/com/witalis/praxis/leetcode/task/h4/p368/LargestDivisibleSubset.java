package com.witalis.praxis.leetcode.task.h4.p368;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p368.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 368,
    description = "Largest Divisible Subset",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, DYNAMIC_PROGRAMMING, SORTING}
)
public class LargestDivisibleSubset extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 1_000;
    public static final int VALUE = 2_000_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given a set of distinct positive integers nums, return the largest subset answer such
                that every pair (answer[i], answer[j]) of elements in this subset satisfies:
                * answer[i] % answer[j] == 0, or
                * answer[j] % answer[i] == 0

            If there are multiple solutions, return any of them.

        Example:
            Input: nums = [1,2,3]
            Output: [1,2]
            Explanation: [1,3] is also accepted.""";

    public LargestDivisibleSubset(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3816 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 3813 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1992 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
