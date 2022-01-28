package com.witalis.praxis.leetcode.task.h1.p94;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p94.content.*;
import com.witalis.praxis.leetcode.task.h1.p94.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 94,
    description = "Binary Tree Inorder Traversal",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class BinaryTreeInorderTraversal extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 100;
    public static final int VALUE = 100;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree,
            return the inorder traversal of its nodes' values.
            
        Example:
            Input: root = [1,null,2,3]
            Output: [1,3,2]""";

    public BinaryTreeInorderTraversal(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var tree = new Integer[] {7,4,3,1,null,6,0,null,8,null,null,7,null,5,9};
        log.info("INIT: tree {}", Arrays.toString(tree));

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        log.info("ROOT: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 472 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 466 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 453 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
