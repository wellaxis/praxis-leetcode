package com.witalis.praxis.leetcode.task.h8.p783;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p783.content.*;
import com.witalis.praxis.leetcode.task.h8.p783.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 783,
    description = "Minimum Distance Between BST Nodes",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class MinimumDistanceBetweenBSTNodes extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 100_000;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a Binary Search Tree (BST),
                return the minimum difference between the values of any two different nodes in the tree.

        Example:
            Input: root = [4,2,6,1,3]
            Output: 1""";

    public MinimumDistanceBetweenBSTNodes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        int[] tree = random.ints(len, 0, VALUE + 1)
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

    // time = 779 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 523 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 516 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
