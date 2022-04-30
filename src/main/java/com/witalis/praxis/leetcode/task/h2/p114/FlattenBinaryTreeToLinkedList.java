package com.witalis.praxis.leetcode.task.h2.p114;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p114.content.*;
import com.witalis.praxis.leetcode.task.h2.p114.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 114,
    description = "Flatten Binary Tree to Linked List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, STACK, TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class FlattenBinaryTreeToLinkedList extends LeetCodeTask<TreeNode> {
    public static final int LEN = 2_000;
    public static final int VALUE = 100;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, flatten the tree into a "linked list":
            * The "linked list" should use the same TreeNode class where
              the right child pointer points to the next node in the list
              and the left child pointer is always null.
            * The "linked list" should be in the same order
              as a pre-order traversal of the binary tree.

        Example:
            Input: root = [1,2,5,3,4,null,6]
            Output: [1,null,2,null,3,null,4,null,5,null,6]""";

    public FlattenBinaryTreeToLinkedList(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var tree = new Integer[] {
            7,
            4, 3,
            3, 1, 20, 11,
            null, 16, 8, 9, null, null, 5, 6,
            null, null, null, null, 10, null, 12, 9, null, null, null, null, 4, 1, null, 3
        };
        log.info("INIT: tree {}", Arrays.toString(tree));
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 729 ms
    @Override
    protected TreeNode original() {
        var original = new Original(TreeNode.cloneTree(root));
        return original.process();
    }

    // time = 487 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(TreeNode.cloneTree(root));
        return practice.process();
    }

    // time = 463 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(TreeNode.cloneTree(root));
        return solution.process();
    }
}
