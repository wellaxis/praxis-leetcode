package com.witalis.praxis.leetcode.task.h1.p24;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p24.content.*;
import com.witalis.praxis.leetcode.task.h1.p24.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 24,
    description = "Swap Nodes in Pairs",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, RECURSION}
)
public class SwapNodesInPairs extends LeetCodeTask<ListNode> {
    public static final int NUMBER = 101;
    private ListNode head;

    public static final String INFORMATION = """

        Description:
            Given a linked list, swap every two adjacent nodes and return its head.
            You must solve the problem without modifying the values in the list's nodes
            (i.e., only nodes themselves may be changed.)
        Example:
            Input: head = [1,2,3,4]
            Output: [2,1,4,3]""";

    public SwapNodesInPairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(NUMBER);

        log.info("Head is {}", head);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 426 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 420 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 416 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
