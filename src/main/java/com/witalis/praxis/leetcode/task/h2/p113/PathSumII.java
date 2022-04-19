package com.witalis.praxis.leetcode.task.h2.p113;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p113.content.*;
import com.witalis.praxis.leetcode.task.h2.p113.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 113,
    description = "Path Sum II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {BACKTRACKING, TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class PathSumII extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 5_000;
    public static final int VALUE = 1_000;
    private TreeNode root;
    private int sum;

    public static final String INFORMATION = """

        Given the root of a binary tree and an integer targetSum,
            return all root-to-leaf paths where the sum
            of the node values in the path equals targetSum.
            Each path should be returned as a list of the node values,
            not node references.

        A root-to-leaf path is a path starting from the root
            and ending at any leaf node. A leaf is a node with no children.

        Example:
            Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
            Output: [[5,4,11,2],[5,8,4,5]]
            Explanation:
                There are two paths whose sum equals targetSum:
                5 + 4 + 11 + 2 = 22
                5 + 8 + 4 + 5 = 22""";

    public PathSumII(int id, String description, TaskRevision revision) {
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
        this.sum = 30;

        log.info("Root: {}", root.toString());
        log.info("Target sum: {}", sum);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 648 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(root, sum);
        return original.process();
    }

    // time = 619 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(root, sum);
        return practice.process();
    }

    // time = 456 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(root, sum);
        return solution.process();
    }
}
