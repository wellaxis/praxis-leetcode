package com.witalis.praxis.leetcode.task.h7.p637;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p637.content.*;
import com.witalis.praxis.leetcode.task.h7.p637.option.*;
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
    id = 637,
    description = "Average of Levels in Binary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class AverageOfLevelsInBinaryTree extends LeetCodeTask<List<Double>> {
    public static final int LEN = 10_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
            Answers within 10-5 of the actual answer will be accepted.

        Example:
            Input: root = [3,9,20,15,7]
            Output: [3.00000,14.50000,11.00000]""";

    public AverageOfLevelsInBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
            }
        }
        var tree = values.toArray(Integer[]::new);
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("Root is {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5575 ms
    @Override
    protected List<Double> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 2500 ms
    @Override
    protected List<Double> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 1135 ms
    @Override
    protected List<Double> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
