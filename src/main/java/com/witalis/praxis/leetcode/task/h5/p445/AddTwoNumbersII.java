package com.witalis.praxis.leetcode.task.h5.p445;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p445.content.*;
import com.witalis.praxis.leetcode.task.h5.p445.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 445,
    description = "Add Two Numbers II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, MATH, STACK}
)
public class AddTwoNumbersII extends LeetCodeTask<ListNode> {
    public static final int LEN = 100;
    public static final int VALUE = 9;

    private ListNode list1;
    private ListNode list2;

    public static final String INFORMATION = """

        Description:
            You are given two non-empty linked lists representing two non-negative integers.
                The most significant digit comes first and each of their nodes contains a single digit.
                Add the two numbers and return the sum as a linked list.

            You may assume the two numbers do not contain any leading zero, except the number 0 itself.

        Example:
            Input: l1 = [7,2,4,3], l2 = [5,6,4]
            Output: [7,8,0,7]""";

    public AddTwoNumbersII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.list1 = ListNode.initList(LEN, VALUE);
        this.list2 = ListNode.initList(LEN, VALUE);

        log.info("List #1: {}", list1);
        log.info("List #2: {}", list2);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 697 ms
    @Override
    protected ListNode original() {
        var original = new Original(list1, list2);
        return original.process();
    }

    // time = 537 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(list1, list2);
        return practice.process();
    }

    // time = 488 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(list1, list2);
        return solution.process();
    }
}
