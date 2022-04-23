package com.witalis.praxis.leetcode.task.h2.p107;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p107.content.*;
import com.witalis.praxis.leetcode.task.h2.p107.option.*;
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
    id = 107,
    description = "Binary Tree Level Order Traversal II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, BREADTH_FIRST_SEARCH}
)
public class BinaryTreeLevelOrderTraversalII extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 2_000;
    public static final int VALUE = 1_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree,
            return the bottom-up level order traversal of its nodes' values.
            (i.e., from left to right, level by level from leaf to root).

        Example:
            Input: root = [3,9,20,null,null,15,7]
            Output: [[15,7],[9,20],[3]]""";

    public BinaryTreeLevelOrderTraversalII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN);
        List<Integer> values = new ArrayList<>();
        values.add(random.nextInt(-VALUE, VALUE));
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 9) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(-VALUE, VALUE));
            }
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

    // time = 1689 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1595 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 1005 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
