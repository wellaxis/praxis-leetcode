package com.witalis.praxis.leetcode.task.h7.p662;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p662.content.*;
import com.witalis.praxis.leetcode.task.h7.p662.option.*;
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
    id = 662,
    description = "Maximum Width of Binary Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class MaximumWidthOfBinaryTree extends LeetCodeTask<Integer> {
    public static final int LEN = 3_000;
    public static final int VALUE = 100;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, return the maximum width of the given tree.

            The maximum width of a tree is the maximum width among all levels.

            The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
                where the null nodes between the end-nodes that would be present in a complete binary tree
                extending down to that level are also counted into the length calculation.

            It is guaranteed that the answer will in the range of a 32-bit signed integer.

        Example:
            Input: root = [1,3,2,5,null,null,9,6,null,7]
            Output: 7
            Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).""";

    public MaximumWidthOfBinaryTree(int id, String description, TaskRevision revision) {
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

    // time = 964 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 937 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 826 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
