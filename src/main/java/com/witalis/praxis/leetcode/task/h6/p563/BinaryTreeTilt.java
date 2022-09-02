package com.witalis.praxis.leetcode.task.h6.p563;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p563.content.*;
import com.witalis.praxis.leetcode.task.h6.p563.option.*;
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
    id = 563,
    description = "Binary Tree Tilt",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class BinaryTreeTilt extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, return the sum of every tree node's tilt.

        The tilt of a tree node is the absolute difference between the sum
            of all left subtree node values and all right subtree node values.
            If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
            The rule is similar if the node does not have a right child.

        Example:
            Input: root = [4,2,9,3,5,null,7]
            Output: 15
            Explanation:
                Tilt of node 3 : |0-0| = 0 (no children)
                Tilt of node 5 : |0-0| = 0 (no children)
                Tilt of node 7 : |0-0| = 0 (no children)
                Tilt of node 2 : |3-5| = 2 (left subtree is just left child, so sum is 3; right subtree is just right child, so sum is 5)
                Tilt of node 9 : |0-7| = 7 (no left child, so sum is 0; right subtree is just right child, so sum is 7)
                Tilt of node 4 : |(3+5+2)-(9+7)| = |10-16| = 6 (left subtree values are 3, 5, and 2, which sums to 10; right subtree values are 9 and 7, which sums to 16)
                Sum of every tilt : 0 + 0 + 0 + 2 + 7 + 6 = 15""";

    public BinaryTreeTilt(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);
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

    // time = 608 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 485 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 471 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
