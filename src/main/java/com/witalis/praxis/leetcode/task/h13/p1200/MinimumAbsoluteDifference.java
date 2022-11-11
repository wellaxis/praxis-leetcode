package com.witalis.praxis.leetcode.task.h13.p1200;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1200.option.*;
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
    id = 1200,
    description = "Minimum Absolute Difference",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING}
)
public class MinimumAbsoluteDifference extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of distinct integers arr, find all pairs of elements
                with the minimum absolute difference of any two elements.

            Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
                * a, b are from arr
                * a < b
                * b - a equals to the minimum absolute difference of any two elements in arr

        Example:
            Input: arr = [4,2,1,3]
            Output: [[1,2],[2,3],[3,4]]
            Explanation: The minimum absolute difference is 1.
                List all pairs with difference equal to 1 in ascending order.""";

    public MinimumAbsoluteDifference(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            -VALUE, VALUE + 1
        ).distinct().toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // dfs, time = 10029 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // dfs, time = 10396 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // bfs, time = 10084 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
