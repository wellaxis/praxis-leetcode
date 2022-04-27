package com.witalis.praxis.leetcode.task.h2.p105;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p105.content.*;
import com.witalis.praxis.leetcode.task.h2.p105.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 105,
    description = "Construct Binary Tree from Preorder and Inorder Traversal",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, DIVIDE_AND_CONQUER, TREE, BINARY_TREE}
)
public class ConstructBinaryTreeFromPreorderAndInorderTraversal extends LeetCodeTask<TreeNode> {
    public static final int LEN = 100;
    public static final int VALUE = 3_000;
    private int[] preorder;
    private int[] inorder;

    public static final String INFORMATION = """

        Given two integer arrays preorder and inorder
            where preorder is the preorder traversal of a binary tree
            and inorder is the inorder traversal of the same tree,
            construct and return the binary tree.

        Example:
            Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
            Output: [3,9,20,null,null,15,7]""";

    public ConstructBinaryTreeFromPreorderAndInorderTraversal(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            values.add(random.nextInt(0, VALUE));
        }

        var data = values.toArray(Integer[]::new);
        var tree = TreeNode.initTree(data, new TreeNode(), 0);

        this.preorder = TreeNode.preorder(tree);
        this.inorder = TreeNode.inorder(tree);

        log.info("Preorder: {}", Arrays.toString(preorder));
        log.info("Inorder: {}", Arrays.toString(inorder));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 668 ms
    @Override
    protected TreeNode original() {
        var original = new Original(preorder.clone(), inorder.clone());
        return original.process();
    }

    // time = 500 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(preorder.clone(), inorder.clone());
        return practice.process();
    }

    // time = 465 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(preorder.clone(), inorder.clone());
        return solution.process();
    }
}
