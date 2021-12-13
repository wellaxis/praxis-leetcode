package com.witalis.praxis.leetcode.task.p39;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p39.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 39, description = "Combination Sum")
public class CombinationSum extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 30;
    public static final int VALUE_CANDIDATE = 200;
    public static final int VALUE_TARGET = 500;

    private int[] candidates;
    private int target;

    public static final String INFORMATION = """

        Given an array of distinct integers candidates and a target
            integer target, return a list of all unique combinations
            of candidates where the chosen numbers sum to target.
            You may return the combinations in any order.

        The same number may be chosen from candidates
            an unlimited number of times. Two combinations are unique
            if the frequency of at least one of the chosen numbers is different.

        It is guaranteed that the number of unique combinations
            that sum up to target is less than 150 combinations for the given input.

        Example:
            Input: candidates = [2,3,5], target = 8
            Output: [[2,2,2,2],[2,3,3],[3,5]]
            Note: that every number can be used multiple times.""";

    public CombinationSum(int id, String description, TaskRevision revision) {
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

    // time = 638012 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(candidates.clone(), target);
        return original.process();
    }

    // time = 108503 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(candidates.clone(), target);
        return practice.process();
    }

    // time = 113918 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(candidates.clone(), target);
        return solution.process();
    }
}
