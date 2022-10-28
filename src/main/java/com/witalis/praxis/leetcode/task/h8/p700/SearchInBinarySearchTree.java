package com.witalis.praxis.leetcode.task.h8.p700;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p700.content.*;
import com.witalis.praxis.leetcode.task.h8.p700.option.*;
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
    id = 700,
    description = "Search in a Binary Search Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE}
)
public class SearchInBinarySearchTree extends LeetCodeTask<TreeNode> {
    public static final int LEN = 5_000;
    public static final int VALUE = 10_000_000;
    private TreeNode root;
    private int value;

    public static final String INFORMATION = """

        Description:
            You are given the root of a binary search tree (BST) and an integer val.

            Find the node in the BST that the node's value equals val and return
                the subtree rooted with that node. If such a node does not exist, return null.

        Example:
            Input: root = [4,2,7,1,3], val = 2
            Output: [2,1,3]""";

    public SearchInBinarySearchTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        int counter = 0;
        while (counter <= len) {
            values.add(random.nextInt(1, VALUE + 1));
            counter++;
        }
        int[] tree = values.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();

        this.root = TreeNode.initTree(tree);
        this.value = random.nextInt(1, VALUE + 1);

        log.info("Root: {}", root.toString());
        log.info("Value is {}", value);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 794 ms
    @Override
    protected TreeNode original() {
        var original = new Original(root, value);
        return original.process();
    }

    // time = 783 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(root, value);
        return practice.process();
    }

    // time = 761 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(root, value);
        return solution.process();
    }
}
