package com.witalis.praxis.leetcode.task.h1.p90;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p90.option.*;
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
    id = 90,
    description = "Subsets II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BACKTRACKING, BIT_MANIPULATION}
)
public class SubsetsII extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 20;
    public static final int VALUE = 10;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums that may contain duplicates,
            return all possible subsets (the power set).

        The solution set must not contain duplicate subsets.
            Return the solution in any order.

        Example:
            Input: nums = [1,2,2]
            Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]""";

    public SubsetsII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers are '{}'", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2801 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1015 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 459 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
