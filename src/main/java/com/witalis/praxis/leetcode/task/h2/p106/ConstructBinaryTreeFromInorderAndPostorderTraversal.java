package com.witalis.praxis.leetcode.task.h2.p106;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p106.content.*;
import com.witalis.praxis.leetcode.task.h2.p106.option.*;
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
    id = 106,
    description = "Construct Binary Tree from Inorder and Postorder Traversal",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, DIVIDE_AND_CONQUER, TREE, BINARY_TREE}
)
public class ConstructBinaryTreeFromInorderAndPostorderTraversal extends LeetCodeTask<TreeNode> {
    public static final int LEN = 100;
    public static final int VALUE = 3_000;
    private int[] inorder;
    private int[] postorder;

    public static final String INFORMATION = """

        Given two integer arrays inorder and postorder
            where inorder is the inorder traversal of a binary tree
            and postorder is the postorder traversal of the same tree,
            construct and return the binary tree.

        Example:
            Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
            Output: [3,9,20,null,null,15,7]""";

    public ConstructBinaryTreeFromInorderAndPostorderTraversal(int id, String description, TaskRevision revision) {
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

        this.inorder = TreeNode.inorder(tree);
        this.postorder = TreeNode.postorder(tree);

        log.info("Inorder: {}", Arrays.toString(inorder));
        log.info("Postorder: {}", Arrays.toString(postorder));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 693 ms
    @Override
    protected TreeNode original() {
        var original = new Original(inorder.clone(), postorder.clone());
        return original.process();
    }

    // time = 495 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(inorder.clone(), postorder.clone());
        return practice.process();
    }

    // time = 428 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(inorder.clone(), postorder.clone());
        return solution.process();
    }
}
