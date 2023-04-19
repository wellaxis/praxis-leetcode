package com.witalis.praxis.leetcode.task.h14.p1372;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1372.content.*;
import com.witalis.praxis.leetcode.task.h14.p1372.option.*;
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
    id = 1372,
    description = "Longest ZigZag Path in a Binary Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, DYNAMIC_PROGRAMMING}
)
public class LongestZigZagPathInBinaryTree extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = 100;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            You are given the root of a binary tree.

            A ZigZag path for a binary tree is defined as follow:
                * Choose any node in the binary tree and a direction (right or left).
                * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
                * Change the direction from right to left or from left to right.
                * Repeat the second and third steps until you can't move in the tree.

            Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

            Return the longest ZigZag path contained in that tree.

        Example:
            Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
            Output: 3
            Explanation: Longest ZigZag path in blue nodes (right -> left -> right).""";

    public LongestZigZagPathInBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = generate();

        log.info("Root is {}", root.toString());
    }

    private static TreeNode generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(1, VALUE + 1));
            }
        }
        Integer[] tree = values.toArray(Integer[]::new);
        return TreeNode.initTree(tree, new TreeNode(), 0);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1253 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1189 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 939 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
