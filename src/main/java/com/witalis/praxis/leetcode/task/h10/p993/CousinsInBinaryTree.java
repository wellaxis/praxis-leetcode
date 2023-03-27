package com.witalis.praxis.leetcode.task.h10.p993;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p993.content.*;
import com.witalis.praxis.leetcode.task.h10.p993.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 993,
    description = "Cousins in Binary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class CousinsInBinaryTree extends LeetCodeTask<Boolean> {
    public static final int LEN = 100;
    public static final int VALUE = 100;

    private TreeNode root;
    private int value1;
    private int value2;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
                return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

            Two nodes of a binary tree are cousins if they have the same depth with different parents.

            Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

        Example:
            Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
            Output: true""";

    public CousinsInBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        List<Integer> nodes = new ArrayList<>(IntStream.range(1, len).boxed().toList());
        Collections.shuffle(nodes);
        Integer[] tree = new Integer[len];
        tree[0] = 0;
        for (int i = 1; i < len; i++) {
            tree[i] = nodes.get(i - 1);
        }
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        this.value1 = random.nextInt(1, len);
        this.value2 = random.nextInt(1, len);
        while (value2 == value1) {
            value2 = random.nextInt(1, len);
        }

        log.info("Root: {}", root.toString());
        log.info("Value #1: {}", value1);
        log.info("Value #2: {}", value2);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 944 ms
    @Override
    protected Boolean original() {
        var original = new Original(root, value1, value2);
        return original.process();
    }

    // time = 794 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root, value1, value2);
        return practice.process();
    }

    // time = 896 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root, value1, value2);
        return solution.process();
    }
}
