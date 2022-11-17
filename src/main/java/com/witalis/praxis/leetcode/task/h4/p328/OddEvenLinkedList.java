package com.witalis.praxis.leetcode.task.h4.p328;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p328.content.*;
import com.witalis.praxis.leetcode.task.h4.p328.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 328,
    description = "Odd Even Linked List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST}
)
public class OddEvenLinkedList extends LeetCodeTask<ListNode> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000;

    private ListNode head;

    public static final String INFORMATION = """

        Description:
            Given the head of a singly linked list, group all the nodes with odd indices together
                followed by the nodes with even indices, and return the reordered list.

            The first node is considered odd, and the second node is even, and so on.

            Note that the relative order inside both the even and odd groups should remain as it was in the input.

            You must solve the problem in O(1) extra space complexity and O(n) time complexity.

        Example:
            Input: head = [2,1,3,5,6,4,7]
            Output: [2,3,6,7,1,5,4]""";

    public OddEvenLinkedList(int id, String description, TaskRevision revision) {
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

    // time = 1419 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 1000 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 722 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
