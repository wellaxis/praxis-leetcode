package com.witalis.praxis.leetcode.task.h2.p141;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p141.content.*;
import com.witalis.praxis.leetcode.task.h2.p141.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 141,
    description = "Linked List Cycle",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, LINKED_LIST, TWO_POINTERS}
)
public class LinkedListCycle extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;

    private ListNode head;

    public static final String INFORMATION = """

        Given head, the head of a linked list,
            determine if the linked list has a cycle in it.

        There is a cycle in a linked list if there is some node in the list
            that can be reached again by continuously following the next pointer.
            Internally, pos is used to denote the index of the node
            that tail's next pointer is connected to.
            Note that pos is not passed as a parameter.

        Return true if there is a cycle in the linked list.
            Otherwise, return false.

        Example:
            Input: head = [3,2,0,-4], pos = 1
            Output: true
            Explanation: There is a cycle in the linked list,
                where the tail connects to the 1st node (0-indexed).""";

    public LinkedListCycle(int id, String description, TaskRevision revision) {
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

    // time = 1565 ms
    @Override
    protected Boolean original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 903 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 801 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
