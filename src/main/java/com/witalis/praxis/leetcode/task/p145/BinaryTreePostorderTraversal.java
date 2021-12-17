package com.witalis.praxis.leetcode.task.p145;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p145.content.*;
import com.witalis.praxis.leetcode.task.p145.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 145,
    description = "Binary Tree Postorder Traversal",
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class BinaryTreePostorderTraversal extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 100;
    public static final int VALUE = 100;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree,
            return the postorder traversal of its nodes' values.

        Example:
            Input: root = [1,null,2,3]
            Output: [3,2,1]""";

    public BinaryTreePostorderTraversal(int id, String description, TaskRevision revision) {
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

    // time = 520 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 477 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 477 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
