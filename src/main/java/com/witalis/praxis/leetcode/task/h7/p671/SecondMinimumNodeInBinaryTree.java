package com.witalis.praxis.leetcode.task.h7.p671;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p671.content.*;
import com.witalis.praxis.leetcode.task.h7.p671.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 671,
    description = "Second Minimum Node In a Binary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class SecondMinimumNodeInBinaryTree extends LeetCodeTask<Integer> {
    public static final int LEN = 25_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given a non-empty special binary tree consisting of nodes with the non-negative value,
                where each node in this tree has exactly two or zero sub-node.
                If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
                More formally, the property root.val = min(root.left.val, root.right.val) always holds.
    
            Given such a binary tree, you need to output the second minimum value
                in the set made of all the nodes' value in the whole tree.
    
            If no such second minimum value exists, output -1 instead.

        Example:
            Input: root = [2,2,5,null,null,5,7]
            Output: 5
            Explanation: The smallest value is 2, the second smallest value is 5.""";

    public SecondMinimumNodeInBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = TreeNode.initTree(LEN);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2221 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 858 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 533 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
