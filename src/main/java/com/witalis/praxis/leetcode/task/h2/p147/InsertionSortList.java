package com.witalis.praxis.leetcode.task.h2.p147;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p147.content.*;
import com.witalis.praxis.leetcode.task.h2.p147.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 147,
    description = "Insertion Sort List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, SORTING}
)
public class InsertionSortList extends LeetCodeTask<ListNode> {
    public static final int LEN = 5_000;
    public static final int VALUE = 5_000;

    private ListNode head;

    public static final String INFORMATION = """

        Given the head of a singly linked list, sort the list using insertion sort,
            and return the sorted list's head.

        The steps of the insertion sort algorithm:
            1. Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
            2. At each iteration, insertion sort removes one element from the input data,
               finds the location it belongs within the sorted list and inserts it there.
            3. It repeats until no input elements remain.

        The following is a graphical example of the insertion sort algorithm.
            The partially sorted list (black) initially contains only the first element in the list.
            One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

        Example:
            Input: head = [-1,5,3,4,0]
            Output: [-1,0,3,4,5]""";

    public InsertionSortList(int id, String description, TaskRevision revision) {
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

    // time = 5099 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 1025 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 15685 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
