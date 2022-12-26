package com.witalis.praxis.leetcode.task.h24.p2389;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2389.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2389,
    description = "Longest Subsequence With Limited Sum",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BINARY_SEARCH, GREEDY, SORTING, PREFIX_SUM}
)
public class LongestSubsequenceWithLimitedSum extends LeetCodeTask<int[]> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000_000;
    private int[] numbers;
    private int[] queries;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums of length n, and an integer array queries of length m.

            Return an array answer of length m where answer[i] is the maximum size of a subsequence
                that you can take from nums such that the sum of its elements is less than or equal to queries[i].

            A subsequence is an array that can be derived from another array by deleting some or no elements
                without changing the order of the remaining elements.

        Example:
            Input: nums = [4,5,2,1], queries = [3,10,21]
            Output: [2,3,4]
            Explanation: We answer the queries as follows:
                - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
                - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
                - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.""";

    public LongestSubsequenceWithLimitedSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();
        this.queries = generate();

        log.info("Numbers are {}", Arrays.toString(numbers));
        log.info("Queries are {}", Arrays.toString(queries));
    }

    private static int[] generate() {
        final var random = ThreadLocalRandom.current();

        return random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5986 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone(), queries.clone());
        return original.process();
    }

    // time = 4577 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone(), queries.clone());
        return practice.process();
    }

    // time = 2900 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone(), queries.clone());
        return solution.process();
    }
}
