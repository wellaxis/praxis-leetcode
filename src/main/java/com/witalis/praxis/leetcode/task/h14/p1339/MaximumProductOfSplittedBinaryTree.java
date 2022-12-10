package com.witalis.praxis.leetcode.task.h14.p1339;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1339.content.*;
import com.witalis.praxis.leetcode.task.h14.p1339.option.*;
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
    id = 1339,
    description = "Maximum Product of Splitted Binary Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class MaximumProductOfSplittedBinaryTree extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = 10_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, split the binary tree into two subtrees by removing one edge
                such that the product of the sums of the subtrees is maximized.

            Return the maximum product of the sums of the two subtrees.
                Since the answer may be too large, return it modulo 10^9 + 7.

            Note that you need to maximize the answer before taking the mod and not after taking it.

        Example:
            Input: root = [1,null,2,3,4,null,null,5,6]
            Output: 90
            Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)""";

    public MaximumProductOfSplittedBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = generate();

        log.info("Root is {}", root.toString());
    }

    private static TreeNode generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
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

    // time = 3984 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 2081 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 2350 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
