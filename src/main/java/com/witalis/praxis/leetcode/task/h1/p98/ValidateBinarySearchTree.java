package com.witalis.praxis.leetcode.task.h1.p98;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p98.content.*;
import com.witalis.praxis.leetcode.task.h1.p98.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 98,
    description = "Validate Binary Search Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH}
)
public class ValidateBinarySearchTree extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, determine if it is a valid binary search tree (BST).

        A valid BST is defined as follows:
            * The left subtree of a node contains only nodes with keys less than the node's key.
            * The right subtree of a node contains only nodes with keys greater than the node's key.
            * Both the left and right subtrees must also be binary search trees.

        Example:
            Input: root = [2,1,3]
            Output: true""";

    public ValidateBinarySearchTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var tree = new Integer[] {
            10,
            3, 12,
            1, 6, 11, 16,
            null, 2, 7, 8, null, null, 14, 17,
            null, null, null, null, 4, null, 5, 9, null, null, null, null, 13, 15, null, 18
        };
        log.info("INIT: tree {}", Arrays.toString(tree));

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        log.info("ROOT: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 484 ms
    @Override
    protected Boolean original() {
        var original = new Original(TreeNode.cloneTree(root));
        return original.process();
    }

    // time = 413 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(TreeNode.cloneTree(root));
        return practice.process();
    }

    // time = 406 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(TreeNode.cloneTree(root));
        return solution.process();
    }
}
