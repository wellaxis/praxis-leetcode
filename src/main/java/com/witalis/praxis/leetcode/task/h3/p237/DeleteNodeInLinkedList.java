package com.witalis.praxis.leetcode.task.h3.p237;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p237.content.*;
import com.witalis.praxis.leetcode.task.h3.p237.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 237,
    description = "Delete Node in a Linked List",
    difficulty = TaskDifficulty.EASY,
    tags = {LINKED_LIST}
)
public class DeleteNodeInLinkedList extends LeetCodeTask<ListNode> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private ListNode head;

    public static final String INFORMATION = """

        Write a function to delete a node in a singly-linked list.
            You will not be given access to the head of the list,
            instead you will be given access to the node to be deleted directly.

        It is guaranteed that the node to be deleted is not a tail node in the list.

        Example:
            Input: head = [4,5,1,9], node = 5
            Output: [4,1,9]
            Explanation: You are given the second node with value 5,
                the linked list should become 4 -> 1 -> 9 after calling your function.""";

    public DeleteNodeInLinkedList(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);

        log.info("Node is {}", head);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 553 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 552 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 551 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
