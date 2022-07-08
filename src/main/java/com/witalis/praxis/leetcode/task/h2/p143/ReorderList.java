package com.witalis.praxis.leetcode.task.h2.p143;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p143.content.*;
import com.witalis.praxis.leetcode.task.h2.p143.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 143,
    description = "Reorder List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TWO_POINTERS, STACK, RECURSION}
)
public class ReorderList extends LeetCodeTask<ListNode> {
    public static final int LEN = 50_000;
    public static final int VALUE = 1_000;

    private ListNode head;

    public static final String INFORMATION = """

        You are given the head of a singly linked-list. The list can be represented as:
            L0 → L1 → … → Ln - 1 → Ln

        Reorder the list to be on the following form:
            L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

        You may not modify the values in the list's nodes. Only nodes themselves may be changed.

        Example:
            Input: head = [1,2,3,4,5]
            Output: [1,5,2,4,3]""";

    public ReorderList(int id, String description, TaskRevision revision) {
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

    // time = 2239 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 2119 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 1379 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
