package com.witalis.praxis.leetcode.task.h9.p876;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p876.content.*;
import com.witalis.praxis.leetcode.task.h9.p876.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 876,
    description = "Middle of the Linked List",
    difficulty = TaskDifficulty.EASY,
    tags = {LINKED_LIST, TWO_POINTERS}
)
public class MiddleOfLinkedList extends LeetCodeTask<ListNode> {
    public static final int LEN = 100;
    public static final int VALUE = 100;

    private ListNode head;

    public static final String INFORMATION = """

        Description:
            Given the head of a singly linked list, return the middle node of the linked list.

            If there are two middle nodes, return the second middle node.

        Example:
            Input: head = [1,2,3,4,5]
            Output: [3,4,5]
            Explanation: The middle node of the list is node 3.""";

    public MiddleOfLinkedList(int id, String description, TaskRevision revision) {
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

    // time = 650 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 479 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 513 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
