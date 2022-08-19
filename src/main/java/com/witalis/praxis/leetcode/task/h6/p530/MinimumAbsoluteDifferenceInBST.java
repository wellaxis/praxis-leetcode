package com.witalis.praxis.leetcode.task.h6.p530;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p530.content.*;
import com.witalis.praxis.leetcode.task.h6.p530.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 530,
    description = "Minimum Absolute Difference in BST",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class MinimumAbsoluteDifferenceInBST extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a Binary Search Tree (BST),
            return the minimum absolute difference between the values of any two different nodes in the tree.

        Example:
            Input: root = [1,0,48,null,null,12,49]
            Output: 1""";

    public MinimumAbsoluteDifferenceInBST(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        var tree = random.ints(len, 0, VALUE + 1)
            .distinct()
            .sorted()
            .boxed()
            .mapToInt(Integer::intValue)
            .toArray();
        this.root = TreeNode.initTree(tree);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2271 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1820 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 911 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
