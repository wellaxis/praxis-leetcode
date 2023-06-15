package com.witalis.praxis.leetcode.task.h12.p1161;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1161.content.*;
import com.witalis.praxis.leetcode.task.h12.p1161.option.*;
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
    id = 1161,
    description = "Maximum Level Sum of a Binary Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class MaximumLevelSumOfBinaryTree extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

            Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

        Example:
            Input: root = [1,7,0,7,-8,null,null]
            Output: 2
            Explanation:
                Level 1 sum = 1.
                Level 2 sum = 7 + 0 = 7.
                Level 3 sum = 7 + -8 = -1.
                So we return the level with the maximum sum which is level 2.""";

    public MaximumLevelSumOfBinaryTree(int id, String description, TaskRevision revision) {
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
                values.add(random.nextInt(-VALUE, VALUE + 1));
            }
        }
        Integer[] tree = values.toArray(Integer[]::new);
        return TreeNode.initTree(tree, new TreeNode(), 0);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1900 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 637 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 1041 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
