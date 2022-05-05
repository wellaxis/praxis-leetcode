package com.witalis.praxis.leetcode.task.h3.p203;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p203.content.*;
import com.witalis.praxis.leetcode.task.h3.p203.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 203,
    description = "Remove Linked List Elements",
    difficulty = TaskDifficulty.EASY,
    tags = {LINKED_LIST, RECURSION}
)
public class RemoveLinkedListElements extends LeetCodeTask<ListNode> {
    public static final int LEN = 10_000;
    public static final int VALUE = 50;

    private ListNode head;
    private int value;

    public static final String INFORMATION = """

        Given the head of a linked list and an integer val,
            remove all the nodes of the linked list that has Node.val == val,
            and return the new head.

        Example:
            Input: head = [1,2,6,3,4,5,6], val = 6
            Output: [1,2,3,4,5]""";

    public RemoveLinkedListElements(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);
        this.value = ThreadLocalRandom.current().nextInt(0, VALUE + 1);

        log.info("Node is {}", head);
        log.info("Value is {}", value);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1093 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone(), value);
        return original.process();
    }

    // time = 959 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone(), value);
        return practice.process();
    }

    // time = 1362 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone(), value);
        return solution.process();
    }
}
