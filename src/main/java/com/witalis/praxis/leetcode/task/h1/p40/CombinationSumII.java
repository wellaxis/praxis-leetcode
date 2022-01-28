package com.witalis.praxis.leetcode.task.h1.p40;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p40.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 40,
    description = "Combination Sum II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BACKTRACKING}
)
public class CombinationSumII extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 100;
    public static final int VALUE_CANDIDATE = 50;
    public static final int VALUE_TARGET = 30;

    private int[] candidates;
    private int target;

    public static final String INFORMATION = """

        Given a collection of candidate numbers (candidates)
            and a target number (target), find all unique combinations
            in candidates where the candidate numbers sum to target.

        Each number in candidates may only be used once in the combination.

        Note: The solution set must not contain duplicate combinations.

        Example:
            Input: candidates = [10,1,2,7,6,1,5], target = 8
            Output: [[1,1,6],[1,2,5],[1,7],[2,6]]""";

    public CombinationSumII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.candidates = random.ints(
            LEN, 1, VALUE_CANDIDATE + 1
        ).distinct().toArray();
        this.target = random.nextInt(1, VALUE_TARGET + 1);

        log.info("Candidates are {}", candidates);
        log.info("Target is {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1951 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(candidates.clone(), target);
        return original.process();
    }

    // time = 578 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(candidates.clone(), target);
        return practice.process();
    }

    // time = 982 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(candidates.clone(), target);
        return solution.process();
    }
}
