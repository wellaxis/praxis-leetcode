package com.witalis.praxis.leetcode.task.h3.p226;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p226.content.*;
import com.witalis.praxis.leetcode.task.h3.p226.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 226,
    description = "Invert Binary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class InvertBinaryTree extends LeetCodeTask<TreeNode> {
    public static final int LEN = 100;
    public static final int VALUE = 100;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, invert the tree, and return its root.

        Example:
            Input: root = [4,2,7,1,3,6,9]
            Output: [4,7,2,9,6,3,1]""";

    public InvertBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, 10 * LEN);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            values.add(random.nextInt(-VALUE, VALUE));
        }
        var tree = values.toArray(Integer[]::new);
        log.info("INIT: tree {}", Arrays.toString(tree));

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 677 ms
    @Override
    protected TreeNode original() {
        var original = new Original(TreeNode.cloneTree(root));
        return original.process();
    }

    // time = 661 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(TreeNode.cloneTree(root));
        return practice.process();
    }

    // time = 648 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(TreeNode.cloneTree(root));
        return solution.process();
    }
}
