package com.witalis.praxis.leetcode.task.h1.p77;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p77.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 77,
    description = "Combinations",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BACKTRACKING}
)
public class Combinations extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 20;
    private int n;
    private int k;

    public static final String INFORMATION = """

        Given two integers n and k, return
            all possible combinations of k numbers out of the range [1, n].

        You may return the answer in any order.

        Example:
            Input: n = 4, k = 2
            Output: [[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]]""";

    public Combinations(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.n = ThreadLocalRandom.current().nextInt(1, LEN + 1);
        this.k = ThreadLocalRandom.current().nextInt(1, n + 1);

        log.info("Number N is '{}'", n);
        log.info("Number K is '{}'", k);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3018 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(n, k);
        return original.process();
    }

    // time = 631 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(n, k);
        return practice.process();
    }

    // time = 1156 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(n, k);
        return solution.process();
    }
}
