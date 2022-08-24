package com.witalis.praxis.leetcode.task.h6.p543;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p543.content.*;
import com.witalis.praxis.leetcode.task.h6.p543.option.*;
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
    id = 543,
    description = "Diameter of Binary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class DiameterOfBinaryTree extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, return the length of the diameter of the tree.

        The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
            This path may or may not pass through the root.

        The length of a path between two nodes is represented by the number of edges between them.

        Example:
            Input: root = [1,2,3,4,5]
            Output: 3
            Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].""";

    public DiameterOfBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(-VALUE, VALUE + 1));
            }
        }
        var tree = values.toArray(Integer[]::new);
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3591 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 739 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 725 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
