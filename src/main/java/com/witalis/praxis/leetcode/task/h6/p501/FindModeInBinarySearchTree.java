package com.witalis.praxis.leetcode.task.h6.p501;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p501.content.*;
import com.witalis.praxis.leetcode.task.h6.p501.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 501,
    description = "Find Mode in Binary Search Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH}
)
public class FindModeInBinarySearchTree extends LeetCodeTask<int[]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary search tree (BST) with duplicates,
            return all the mode(s) (i.e., the most frequently occurred element) in it.

        If the tree has more than one mode, return them in any order.

        Assume a BST is defined as follows:
            * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
            * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
            * Both the left and right subtrees must also be binary search trees.

        Example:
            Input: root = [1,null,2,2]
            Output: [2]""";

    public FindModeInBinarySearchTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        int counter = 0;
        while (counter <= len) {
            int value = random.nextInt(-VALUE, VALUE + 1);
            if (random.nextBoolean()) {
                values.add(value);
                counter++;
            } else {
                int quantity = random.nextInt(1, 10);
                List<Integer> list = new ArrayList<>(Collections.nCopies(quantity, value));
                values.addAll(list);
                counter += quantity;
            }
        }
        var tree = values.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        this.root = TreeNode.initTree(tree);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1387 ms
    @Override
    protected int[] original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 957 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 833 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
