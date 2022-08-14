package com.witalis.praxis.leetcode.task.h2.p124;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p124.content.*;
import com.witalis.praxis.leetcode.task.h2.p124.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 124,
    description = "Binary Tree Maximum Path Sum",
    difficulty = TaskDifficulty.HARD,
    tags = {DYNAMIC_PROGRAMMING, TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class BinaryTreeMaximumPathSum extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    public static final int VALUE = 1_000;
    private TreeNode root;

    public static final String INFORMATION = """

        A path in a binary tree is a sequence of nodes where each pair of adjacent nodes
            in the sequence has an edge connecting them.
            A node can only appear in the sequence at most once.
            Note that the path does not need to pass through the root.

        The path sum of a path is the sum of the node's values in the path.

        Given the root of a binary tree, return the maximum path sum of any non-empty path.

        Example:
            Input: root = [-10,9,20,null,null,15,7]
            Output: 42
            Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.""";

    public BinaryTreeMaximumPathSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            values.add(random.nextInt(-VALUE, VALUE + 1));
        }
        var tree = values.toArray(Integer[]::new);
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2144 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 942 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 841 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
