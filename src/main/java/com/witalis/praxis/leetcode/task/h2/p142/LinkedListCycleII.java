package com.witalis.praxis.leetcode.task.h2.p142;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p142.content.*;
import com.witalis.praxis.leetcode.task.h2.p142.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 142,
    description = "Linked List Cycle II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, LINKED_LIST, TWO_POINTERS}
)
public class LinkedListCycleII extends LeetCodeTask<ListNode> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;

    private ListNode head;

    public static final String INFORMATION = """

        Given the head of a linked list, return the node where the cycle begins.
            If there is no cycle, return null.

        There is a cycle in a linked list if there is some node in the list
            that can be reached again by continuously following the next pointer.
            Internally, pos is used to denote the index of the node
            that tail's next pointer is connected to (0-indexed).
            It is -1 if there is no cycle. Note that pos is not passed as a parameter.

        Do not modify the linked list.

        Example:
            Input: head = [3,2,0,-4], pos = 1
            Output: true
            Explanation: There is a cycle in the linked list, where tail connects to the second node.""";

    public LinkedListCycleII(int id, String description, TaskRevision revision) {
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

    // time = 81900 ms
    @Override
    protected ListNode original() {
        var original = new Original(head);
        return original.process();
    }

    // time = 2465 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head);
        return practice.process();
    }

    // time = 460 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head);
        return solution.process();
    }
}
