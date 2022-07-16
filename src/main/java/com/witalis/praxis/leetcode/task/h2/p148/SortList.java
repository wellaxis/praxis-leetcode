package com.witalis.praxis.leetcode.task.h2.p148;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p148.content.*;
import com.witalis.praxis.leetcode.task.h2.p148.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 148,
    description = "Sort List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TWO_POINTERS, DIVIDE_AND_CONQUER, SORTING, MERGE_SORT}
)
public class SortList extends LeetCodeTask<ListNode> {
    public static final int LEN = 50_000;
    public static final int VALUE = 50_000;

    private ListNode head;

    public static final String INFORMATION = """

        Given the head of a linked list, return the list after sorting it in ascending order.

        Example:
            Input: head = [-1,5,3,4,0]
            Output: [-1,0,3,4,5]""";

    public SortList(int id, String description, TaskRevision revision) {
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

    // time = 4176 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 3156 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 3804 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
