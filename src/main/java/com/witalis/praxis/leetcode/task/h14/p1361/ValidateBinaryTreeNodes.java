package com.witalis.praxis.leetcode.task.h14.p1361;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1361.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1361,
    description = "Validate Binary Tree Nodes",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, GRAPH}
)
public class ValidateBinaryTreeNodes extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;

    private int size;
    private int[] leftChildren;
    private int[] rightChildren;

    public static final String INFORMATION = """

        Description:
            You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i],
                return true if and only if all the given nodes form exactly one valid binary tree.

            If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

            Note that the nodes have no values and that we only use the node numbers in this problem.

        Example:
            Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
            Output: true""";

    public ValidateBinaryTreeNodes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.size = random.nextInt(1, LEN + 1);
        this.leftChildren = new int[size];
        this.rightChildren = new int[size];
        for (int i = 0; i < size; i++) {
            leftChildren[i] = (random.nextInt(0, 5) == 0) ? -1 : random.nextInt(0, size);
            rightChildren[i] = (random.nextInt(0, 5) == 0) ? -1 : random.nextInt(0, size);
        }

        log.info("Size 'n': {}", size);
        log.info("Left Children: {}", Arrays.toString(leftChildren));
        log.info("Right Children: {}", Arrays.toString(rightChildren));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 775 ms
    @Override
    protected Boolean original() {
        var original = new Original(size, leftChildren, rightChildren);
        return original.process();
    }

    // time = 727 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(size, leftChildren, rightChildren);
        return practice.process();
    }

    // time = 622 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(size, leftChildren, rightChildren);
        return solution.process();
    }
}
