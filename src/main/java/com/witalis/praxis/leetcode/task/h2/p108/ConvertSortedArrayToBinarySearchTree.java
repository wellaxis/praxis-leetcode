package com.witalis.praxis.leetcode.task.h2.p108;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p108.content.*;
import com.witalis.praxis.leetcode.task.h2.p108.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 108,
    description = "Convert Sorted Array to Binary Search Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, DIVIDE_AND_CONQUER, TREE, BINARY_TREE, BINARY_SEARCH_TREE}
)
public class ConvertSortedArrayToBinarySearchTree extends LeetCodeTask<TreeNode> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums where the elements
            are sorted in ascending order,
            convert it to a height-balanced binary search tree.

        A height-balanced binary tree is a binary tree
            in which the depth of the two subtrees of every node
            never differs by more than one.

        Example:
            Input: nums = [-10,-3,0,5,9]
            Output: [0,-3,9,-10,null,5]
            Explanation: [0,-10,5,null,-3,null,9] is also accepted""";

    public ConvertSortedArrayToBinarySearchTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = generate();

        log.info("Numbers are: {}", numbers);
    }

    private int[] generate() {
        var random = ThreadLocalRandom.current();
        return random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE,
            VALUE + 1
        ).sorted().toArray();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 591 ms
    @Override
    protected TreeNode original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 528 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 545 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
