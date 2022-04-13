package com.witalis.praxis.leetcode.task.h3.p257;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p257.content.*;
import com.witalis.praxis.leetcode.task.h3.p257.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 257,
    description = "Binary Tree Paths",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, BACKTRACKING, TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class BinaryTreePaths extends LeetCodeTask<List<String>> {
    public static final int LEN = 100;
    public static final int VALUE = 100;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree,
            return all root-to-leaf paths in any order.

        A leaf is a node with no children.

        Example:
            Input: root = [1,null,2,3]
            Output: [1,2,3]""";

    public BinaryTreePaths(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var tree = new Integer[] {7,4,3,1,null,6,0,null,8,null,null,2,null,5,9};
        log.info("INIT: tree {}", Arrays.toString(tree));

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        log.info("ROOT: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1148 ms
    @Override
    protected List<String> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1209 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 2645 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
