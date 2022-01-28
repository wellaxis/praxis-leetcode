package com.witalis.praxis.leetcode.task.h2.p110;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p110.content.*;
import com.witalis.praxis.leetcode.task.h2.p110.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 110,
    description = "Balanced Binary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class BalancedBinaryTree extends LeetCodeTask<Boolean> {
    public static final int LEN = 5_000;
    public static final int VALUE = 10_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given a binary tree, determine if it is height-balanced.

        For this problem, a height-balanced binary tree is defined as:
            a binary tree in which the left and right subtrees
            of every node differ in height by no more than 1.

        Example:
            Input: root = [3,9,20,null,null,15,7]
            Output: true""";

    public BalancedBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var tree = new Integer[] {7,4,3,1,null,6,0,null,8,null,null,7,null,5,9};
        log.info("INIT: tree {}", Arrays.toString(tree));

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 391 ms
    @Override
    protected Boolean original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 431 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 435 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
