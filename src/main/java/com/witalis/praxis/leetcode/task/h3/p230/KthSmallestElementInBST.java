package com.witalis.praxis.leetcode.task.h3.p230;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p230.content.*;
import com.witalis.praxis.leetcode.task.h3.p230.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 230,
    description = "Kth Smallest Element in a BST",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH}
)
public class KthSmallestElementInBST extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;
    private TreeNode root;
    private int index;

    public static final String INFORMATION = """

        Given the root of a binary search tree, and an integer k,
            return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

        Example:
            Input: root = [5,3,6,2,4,null,null,1], k = 3
            Output: 3""";

    public KthSmallestElementInBST(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        var tree = random.ints(len, 0, VALUE + 1)
            .distinct()
            .sorted()
            .boxed()
            .mapToInt(Integer::intValue)
            .toArray();
        this.root = TreeNode.initTree(tree);
        this.index = random.nextInt(1, tree.length + 1);

        log.info("Root: {}", root.toString());
        log.info("Index K = {}", index);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 845 ms
    @Override
    protected Integer original() {
        var original = new Original(root, index);
        return original.process();
    }

    // time = 510 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root, index);
        return practice.process();
    }

    // time = 515 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root, index);
        return solution.process();
    }
}
