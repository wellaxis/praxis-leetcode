package com.witalis.praxis.leetcode.task.h2.p112;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p112.content.*;
import com.witalis.praxis.leetcode.task.h2.p112.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 112,
    description = "Path Sum",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class PathSum extends LeetCodeTask<Boolean> {
    public static final int LEN = 5_000;
    public static final int VALUE = 1_000;
    private TreeNode root;
    private int sum;

    public static final String INFORMATION = """

        Given a binary tree, find its minimum depth.

        The minimum depth is the number of nodes along
            the shortest path from the root node down to the nearest leaf node.

        Note: A leaf is a node with no children.

        Example:
            Input: root = [3,9,20,null,null,15,7]
            Output: 2""";

    public PathSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var tree = new Integer[] {7,4,3,1,5,6,0,null,8,null,null,7,null,5,9};
        log.info("INIT: tree {}", Arrays.toString(tree));

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        this.sum = 15;
        log.info("Root: {}", root.toString());
        log.info("Target sum: {}", sum);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 703 ms
    @Override
    protected Boolean original() {
        var original = new Original(root, sum);
        return original.process();
    }

    // time = 628 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root, sum);
        return practice.process();
    }

    // time = 665 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root, sum);
        return solution.process();
    }
}
