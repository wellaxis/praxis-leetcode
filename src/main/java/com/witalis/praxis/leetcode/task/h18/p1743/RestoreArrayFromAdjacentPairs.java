package com.witalis.praxis.leetcode.task.h18.p1743;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1743.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1743,
    description = "Restore the Array From Adjacent Pairs",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE}
)
public class RestoreArrayFromAdjacentPairs extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[][] pairs;

    public static final String INFORMATION = """

        Description:
            There is an integer array nums that consists of n unique elements, but you have forgotten it.
                However, you do remember every pair of adjacent elements in nums.

            You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates
                that the elements ui and vi are adjacent in nums.

            It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs,
                either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.

            Return the original array nums. If there are multiple solutions, return any of them.

        Example:
            Input: adjacentPairs = [[2,1],[3,4],[3,2]]
            Output: [1,2,3,4]
            Explanation: This array has all its adjacent pairs in adjacentPairs.
                Notice that adjacentPairs[i] may not be in left-to-right order.""";

    public RestoreArrayFromAdjacentPairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        this.pairs = new int[len - 1][2];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new int[] {
                random.nextInt(-VALUE, VALUE + 1),
                random.nextInt(-VALUE, VALUE + 1)
            };
        }

        log.info("Adjacent Pairs: {}", Arrays.deepToString(pairs));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7463 ms
    @Override
    protected int[] original() {
        var original = new Original(pairs);
        return original.process();
    }

    // time = 5126 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(pairs);
        return practice.process();
    }

    // time = 3436 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(pairs);
        return solution.process();
    }
}
