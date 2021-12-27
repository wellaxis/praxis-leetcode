package com.witalis.praxis.leetcode.task.p101;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p101.content.*;
import com.witalis.praxis.leetcode.task.p101.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 101,
    description = "Symmetric Tree",
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class SymmetricTree extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    public static final int VALUE = 100;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the roots of two binary trees p and q,
            write a function to check if they are the same or not.

        Two binary trees are considered the same if
            they are structurally identical, and the nodes have the same value.

        Example:
            Input: p = [1,2,3], q = [1,2,3]
            Output: true""";

    public SymmetricTree(int id, String description, TaskRevision revision) {
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

    // time = 587 ms
    @Override
    protected Boolean original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 549 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 520 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
