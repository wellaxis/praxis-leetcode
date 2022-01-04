package com.witalis.praxis.leetcode.task.p206;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p206.content.*;
import com.witalis.praxis.leetcode.task.p206.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 206,
    description = "Reverse Linked List",
    tags = {LINKED_LIST, RECURSION}
)
public class ReverseLinkedList extends LeetCodeTask<ListNode> {
    public static final int LEN = 5_000;
    public static final int VALUE = 5_000;

    private ListNode head;

    public static final String INFORMATION = """

        Given the head of a singly linked list,
            reverse the list, and return the reversed list.

        Example:
            Input: head = [1,2,3,4,5]
            Output: [5,4,3,2,1]""";

    public ReverseLinkedList(int id, String description, TaskRevision revision) {
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

    // time = 910 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 1211 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 1217 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
