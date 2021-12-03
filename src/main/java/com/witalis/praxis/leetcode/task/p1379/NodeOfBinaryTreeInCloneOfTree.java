package com.witalis.praxis.leetcode.task.p1379;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p1379.content.*;
import com.witalis.praxis.leetcode.task.p1379.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@LeetCode(id = 1379, description = "Find a Corresponding Node of a Binary Tree in a Clone of That Tree")
public class NodeOfBinaryTreeInCloneOfTree extends LeetCodeTask<TreeNode> {
    private TreeNode originalTree;
    private TreeNode clonedTree;
    private TreeNode targetNode;

    public static final String INFORMATION = """

        Given two binary trees original and cloned
            and given a reference to a node target in the original tree.
        The cloned tree is a copy of the original tree.
        Return a reference to the same node in the cloned tree.
        Note that you are not allowed to change any of the two trees
            or the target node and the answer must be a reference to a node in the cloned tree.
            
        Input: tree = [7,4,3,null,null,6,19], target = 3
        Output: 3
        Explanation: In all examples the original and cloned trees are shown.
                     The target node is a green node from the original tree.
                     The answer is the yellow node from the cloned tree.""";

    public NodeOfBinaryTreeInCloneOfTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var tree = new Integer[] {7,4,3,1,null,6,0,null,8,null,null,7,null,5,9};
        var value = 5;
        log.info("INIT: value {}, tree {}", value, Arrays.toString(tree));

        this.originalTree = TreeNode.initTree(tree, new TreeNode(), 0);
        this.clonedTree = TreeNode.initTree(tree, new TreeNode(), 0);
        this.targetNode = TreeNode.findNode(originalTree, value);
        log.info("TARGET: {}", targetNode.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1050 ms
    @Override
    protected TreeNode original() {
        var original = new Original(originalTree, clonedTree, targetNode);
        return original.process();
    }

    // time = 1106 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(originalTree, clonedTree, targetNode);
        return practice.process();
    }

    // time = 1107 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(originalTree, clonedTree, targetNode);
        return solution.process();
    }
}
