package com.witalis.praxis.leetcode.task.h3.p235;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p235.content.*;
import com.witalis.praxis.leetcode.task.h3.p235.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 235,
    description = "Lowest Common Ancestor of a Binary Search Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH}
)
public class LowestCommonAncestorOfBinarySearchTree extends LeetCodeTask<TreeNode> {
    public static final int LEN = 100_000;
    public static final int VALUE = (int) Math.pow(10, 9);
    private TreeNode root;
    private TreeNode node1;
    private TreeNode node2;

    public static final String INFORMATION = """

        Given a binary search tree (BST), find the lowest common ancestor (LCA)
            of two given nodes in the BST.

        According to the definition of LCA on Wikipedia:
            “The lowest common ancestor is defined between two nodes p and q
            as the lowest node in T that has both p and q as descendants
            (where we allow a node to be a descendant of itself).”

        Example:
            Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
            Output: 6
            Explanation: The LCA of nodes 2 and 8 is 6.""";

    public LowestCommonAncestorOfBinarySearchTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(2, LEN + 1);
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < len; i++) {
            values.add(random.nextInt(-VALUE, VALUE));
        }
        len = values.size();
        var tree = values.toArray(Integer[]::new);
        log.info("INIT: tree {}", Arrays.toString(tree));

        this.root = TreeNode.initTree(tree, new TreeNode(), 0);
        log.info("Root: {}", root.toString());

        this.node1 = TreeNode.findNode(root, tree[random.nextInt(0, len)]);
        log.info("Node [p]: {}", node1.toString());

        this.node2 = TreeNode.findNode(root, tree[random.nextInt(0, len)]);
        log.info("Node [q]: {}", node2.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 11764 ms
    @Override
    protected TreeNode original() {
        var original = new Original(root, node1, node2);
        return original.process();
    }

    // time = 1047 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(root, node1, node2);
        return practice.process();
    }

    // time = 1150 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(root, node1, node2);
        return solution.process();
    }
}
