package com.witalis.praxis.leetcode.task.h9.p894;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p894.content.*;
import com.witalis.praxis.leetcode.task.h9.p894.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 894,
    description = "All Possible Full Binary Trees",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, RECURSION, DYNAMIC_PROGRAMMING, MEMOIZATION}
)
public class AllPossibleFullBinaryTrees extends LeetCodeTask<List<TreeNode>> {
    public static final int LEN = 20;

    private int nodes;

    public static final String INFORMATION = """

        Description:
            Given an integer n, return a list of all possible full binary trees with n nodes.
                Each node of each tree in the answer must have Node.val == 0.

            Each element of the answer is the root node of one possible tree.
                You may return the final list of trees in any order.

            A full binary tree is a binary tree where each node has exactly 0 or 2 children.

        Example:
            Input: n = 7
            Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]""";

    public AllPossibleFullBinaryTrees(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.nodes = random.nextInt(1, LEN + 1);

        log.info("Nodes N: {}", nodes);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 353021 ms, times limit exceeded
    @Override
    protected List<TreeNode> original() {
        var original = new Original(nodes);
        return original.process();
    }

    // time = 764 ms
    @Override
    protected List<TreeNode> practice() {
        var practice = new Practice(nodes);
        return practice.process();
    }

    // time = 614 ms
    @Override
    protected List<TreeNode> solution() {
        var solution = new Solution(nodes);
        return solution.process();
    }
}
