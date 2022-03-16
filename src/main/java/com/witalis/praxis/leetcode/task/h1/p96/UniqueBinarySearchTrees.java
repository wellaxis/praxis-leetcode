package com.witalis.praxis.leetcode.task.h1.p96;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p96.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 96,
    description = "Unique Binary Search Trees",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, DYNAMIC_PROGRAMMING, TREE, BINARY_TREE, BINARY_SEARCH_TREE}
)
public class UniqueBinarySearchTrees extends LeetCodeTask<Integer> {
    public static final int LEN = 19;
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return the number of structurally unique BST's
            (binary search trees) which has exactly n nodes of unique values from 1 to n.
            
        Example:
            Input: n = 3
            Output: 5""";

    public UniqueBinarySearchTrees(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 457 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 422 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 419 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
