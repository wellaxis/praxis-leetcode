package com.witalis.praxis.leetcode.task.h1.p83;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p83.content.*;
import com.witalis.praxis.leetcode.task.h1.p83.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 83,
    description = "Remove Duplicates from Sorted List",
    difficulty = TaskDifficulty.EASY,
    tags = {LINKED_LIST}
)
public class RemoveDuplicatesFromSortedList extends LeetCodeTask<ListNode> {
    public static final int LEN = 300;
    public static final int VALUE = 100;
    private ListNode head;

    public static final String INFORMATION = """

        Given the head of a sorted linked list,
            delete all duplicates such that each element appears only once.
            Return the linked list sorted as well.

        Example:
            Input: head = [1,1,2,3,3]
            Output: [1,2,3]""";

    public RemoveDuplicatesFromSortedList(int id, String description, TaskRevision revision) {
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

    // time = 538 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 489 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 481 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
