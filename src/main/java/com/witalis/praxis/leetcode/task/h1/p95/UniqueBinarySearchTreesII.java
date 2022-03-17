package com.witalis.praxis.leetcode.task.h1.p95;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p95.content.*;
import com.witalis.praxis.leetcode.task.h1.p95.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 95,
    description = "Unique Binary Search Trees II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING, BACKTRACKING, TREE, BINARY_TREE, BINARY_SEARCH_TREE}
)
public class UniqueBinarySearchTreesII extends LeetCodeTask<List<TreeNode>> {
    public static final int LEN = 8;
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return all the structurally unique BST's (binary search trees),
            which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

        Example:
            Input: n = 3
            Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]""";

    public UniqueBinarySearchTreesII(int id, String description, TaskRevision revision) {
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

    // time = 1158049 ms, time limit exceeded
    @Override
    protected List<TreeNode> original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 2267 ms
    @Override
    protected List<TreeNode> practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 1033 ms
    @Override
    protected List<TreeNode> solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
