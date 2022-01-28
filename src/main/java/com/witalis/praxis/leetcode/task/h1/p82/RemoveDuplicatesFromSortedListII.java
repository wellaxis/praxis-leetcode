package com.witalis.praxis.leetcode.task.h1.p82;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p82.content.*;
import com.witalis.praxis.leetcode.task.h1.p82.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 82,
    description = "Remove Duplicates from Sorted List II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TWO_POINTERS}
)
public class RemoveDuplicatesFromSortedListII extends LeetCodeTask<ListNode> {
    public static final int LEN = 300;
    public static final int VALUE = 100;
    private ListNode head;

    public static final String INFORMATION = """

        Given the head of a sorted linked list,
            delete all nodes that have duplicate numbers,
            leaving only distinct numbers from the original list.
            Return the linked list sorted as well.

        Example:
            Input: head = [1,2,3,3,4,4,5]
            Output: [1,2,5]""";

    public RemoveDuplicatesFromSortedListII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);

        log.info("Head is {}", head);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 471 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 413 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 494 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
