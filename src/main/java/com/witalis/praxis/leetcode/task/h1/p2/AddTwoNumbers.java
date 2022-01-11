package com.witalis.praxis.leetcode.task.h1.p2;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p2.content.*;
import com.witalis.praxis.leetcode.task.h1.p2.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2,
    description = "Add Two Numbers",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, MATH, RECURSION}
)
public class AddTwoNumbers extends LeetCodeTask<ListNode> {
    public static final int NUMBER = 101;

    private ListNode l1;
    private ListNode l2;

    public static final String INFORMATION = """

        Description:
            You are given two non-empty linked lists representing two non-negative integers.
            The digits are stored in reverse order, and each of their nodes contains a single digit.
            Add the two numbers and return the sum as a linked list.
            You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        Example:
            Input: l1 = [2,4,3], l2 = [5,6,4]
            Output: [7,0,8]
            Explanation: 342 + 465 = 807.""";

    public AddTwoNumbers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.l1 = ListNode.initList(NUMBER);
        log.info("Node[1] is {}", l1);
        this.l2 = ListNode.initList(NUMBER);
        log.info("Node[2] is {}", l2);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1631 ms
    @Override
    protected ListNode original() {
        var original = new Original(l1.clone(), l2.clone());
        return original.process();
    }

    // time = 1032 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(l1.clone(), l2.clone());
        return practice.process();
    }

    // time = 1044 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(l1.clone(), l2.clone());
        return solution.process();
    }
}
