package com.witalis.praxis.leetcode.task.h1.p99;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p99.content.*;
import com.witalis.praxis.leetcode.task.h1.p99.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 99,
    description = "Recover Binary Search Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH}
)
public class RecoverBinarySearchTree extends LeetCodeTask<TreeNode> {
    public static final int LEN = 1000;
    private TreeNode root;

    public static final String INFORMATION = """

        You are given the root of a binary search tree (BST),
            where the values of exactly two nodes of the tree were swapped by mistake.
            Recover the tree without changing its structure.

        Example:
            Input: root = [3,1,4,null,null,2]
            Output: [2,1,4,null,null,3]
            Explanation: 2 cannot be in the right subtree of 3 because 2 < 3.
                         Swapping 2 and 3 makes the BST valid.""";

    public RecoverBinarySearchTree(int id, String description, TaskRevision revision) {
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

    // time = 579 ms
    @Override
    protected TreeNode original() {
        var original = new Original(TreeNode.cloneTree(root));
        return original.process();
    }

    // time = 519 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(TreeNode.cloneTree(root));
        return practice.process();
    }

    // time = 481 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(TreeNode.cloneTree(root));
        return solution.process();
    }
}
