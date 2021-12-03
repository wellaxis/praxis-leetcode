package com.witalis.praxis.leetcode.task.p19;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p19.content.*;
import com.witalis.praxis.leetcode.task.p19.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 19, description = "Remove Nth Node From End of List")
public class RemoveNthNodeFromEndOfList extends LeetCodeTask<ListNode> {
    public static final int NUMBER = 31;

    private ListNode head;
    private int index;

    public static final String INFORMATION = """

        Description:
            Given the head of a linked list,
            remove the Nth node from the end of the list
            and return its head.
        Example:
            Input: head = [1,2,3,4,5], n = 2
            Output: [1,2,3,5]""";

    public RemoveNthNodeFromEndOfList(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(NUMBER);
        this.index = ThreadLocalRandom.current().nextInt(1, NUMBER);

        log.info("Node is {}, index is {}", head, index);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 546 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone(), index);
        return original.process();
    }

    // time = 472 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone(), index);
        return practice.process();
    }

    // time = 485 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone(), index);
        return solution.process();
    }
}
