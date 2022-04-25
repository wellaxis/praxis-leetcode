package com.witalis.praxis.leetcode.task.h2.p109;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p109.content.*;
import com.witalis.praxis.leetcode.task.h2.p109.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 109,
    description = "Convert Sorted List to Binary Search Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TREE, BINARY_TREE, BINARY_SEARCH_TREE, DIVIDE_AND_CONQUER}
)
public class ConvertSortedListToBinarySearchTree extends LeetCodeTask<TreeNode> {
    public static final int LEN = 20_000;
    public static final int VALUE = 100_000;
    private ListNode head;

    public static final String INFORMATION = """

        Given the head of a singly linked list where elements are
            sorted in ascending order, convert it to a height balanced BST.

        For this problem, a height-balanced binary tree is defined as a binary tree
            in which the depth of the two subtrees of every node never differ by more than 1.

        Example:
            Input: head = [-10,-3,0,5,9]
            Output: [0,-3,9,-10,null,5]
            Explanation: One possible answer is [0,-3,9,-10,null,5],
                which represents the shown height balanced BST.""";

    public ConvertSortedListToBinarySearchTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initRandom(LEN, VALUE);

        log.info("Head is {}", head);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3105 ms
    @Override
    protected TreeNode original() {
        var original = new Original(head);
        return original.process();
    }

    // time = 2905 ms
    @Override
    protected TreeNode practice() {
        var practice = new Practice(head);
        return practice.process();
    }

    // time = 1159 ms
    @Override
    protected TreeNode solution() {
        var solution = new Solution(head);
        return solution.process();
    }
}
