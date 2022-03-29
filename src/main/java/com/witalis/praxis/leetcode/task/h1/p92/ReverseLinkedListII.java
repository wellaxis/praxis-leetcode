package com.witalis.praxis.leetcode.task.h1.p92;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p92.content.*;
import com.witalis.praxis.leetcode.task.h1.p92.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 92,
    description = "Reverse Linked List II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST}
)
public class ReverseLinkedListII extends LeetCodeTask<ListNode> {
    public static final int LEN = 500;
    public static final int VALUE = 500;
    private ListNode head;
    private int left;
    private int right;

    public static final String INFORMATION = """

        Given the head of a singly linked list and
            two integers left and right where left <= right,
            reverse the nodes of the list from position left
            to position right, and return the reversed list.

        Example:
            Input: head = [1,2,3,4,5], left = 2, right = 4
            Output: [1,4,3,2,5]""";

    public ReverseLinkedListII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);

        int one = ThreadLocalRandom.current().nextInt(1, ListNode.size(head) + 1);
        int two = ThreadLocalRandom.current().nextInt(1, ListNode.size(head) + 1);

        this.left = Math.min(one, two);
        this.right = Math.max(one, two);

        log.info("Head is {}", head);
        log.info("Left is {}", left);
        log.info("Right is {}", right);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 746 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone(), left, right);
        return original.process();
    }

    // time = 494 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone(), left, right);
        return practice.process();
    }

    // time = 514 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone(), left, right);
        return solution.process();
    }
}
