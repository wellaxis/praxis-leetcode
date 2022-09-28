package com.witalis.praxis.leetcode.task.h7.p617;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p617.content.*;
import com.witalis.praxis.leetcode.task.h7.p617.option.*;
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
    id = 617,
    description = "Merge Two Binary Trees",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class MergeTwoBinaryTrees extends LeetCodeTask<TreeNode> {
    public static final int LEN = 2_000;
    public static final int VALUE = 10_000;
    private TreeNode root1;
    private TreeNode root2;

    public static final String INFORMATION = """

        You are given two binary trees root1 and root2.

        Imagine that when you put one of them to cover the other,
            some nodes of the two trees are overlapped while the others are not.
            You need to merge the two trees into a new binary tree.
            The merge rule is that if two nodes overlap,
            then sum node values up as the new value of the merged node.
            Otherwise, the NOT null node will be used as the node of the new tree.

        Return the merged tree.

        Note: The merging process must start from the root nodes of both trees.

        Example:
            Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
            Output: [3,4,5,5,4,null,7]""";

    public MergeTwoBinaryTrees(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root1 = generate();
        this.root2 = generate();

        log.info("Root #1: {}", root1.toString());
        log.info("Root #2: {}", root2.toString());
    }

    private static TreeNode generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(-VALUE, VALUE + 1));
            }
        }
        var tree = values.toArray(Integer[]::new);
        return TreeNode.initTree(tree, new TreeNode(), 0);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 843 ms
    @Override
    protected TreeNode original() {
        var original = new Original(root1, root2);
        return original.process();
    }

    // time = 837 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(root1, root2);
        return practice.process();
    }

    // time = 828 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(root1, root2);
        return solution.process();
    }
}
