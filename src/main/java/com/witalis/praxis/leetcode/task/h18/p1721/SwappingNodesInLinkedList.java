package com.witalis.praxis.leetcode.task.h18.p1721;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1721.content.*;
import com.witalis.praxis.leetcode.task.h18.p1721.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1721,
    description = "Swapping Nodes in a Linked List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TWO_POINTERS}
)
public class SwappingNodesInLinkedList extends LeetCodeTask<ListNode> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100;

    private ListNode head;
    private int value;

    public static final String INFORMATION = """

        Description:
            You are given the head of a linked list, and an integer k.

            Return the head of the linked list after swapping the values of the kth node
                from the beginning and the kth node from the end (the list is 1-indexed).

        Example:
            Input: head = [1,2,3,4,5], k = 2
            Output: [1,4,3,2,5]""";

    public SwappingNodesInLinkedList(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);
        this.value = ThreadLocalRandom.current().nextInt(1, head.size() + 1);

        log.info("Head: {}", head);
        log.info("Value 'k': {}", value);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1093 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone(), value);
        return original.process();
    }

    // time = 959 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone(), value);
        return practice.process();
    }

    // time = 1362 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone(), value);
        return solution.process();
    }
}
