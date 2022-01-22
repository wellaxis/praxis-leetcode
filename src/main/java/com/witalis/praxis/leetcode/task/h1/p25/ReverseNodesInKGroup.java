package com.witalis.praxis.leetcode.task.h1.p25;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p25.content.*;
import com.witalis.praxis.leetcode.task.h1.p25.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 25,
    description = "Reverse Nodes in k-Group",
    difficulty = TaskDifficulty.HARD,
    tags = {LINKED_LIST, RECURSION}
)
public class ReverseNodesInKGroup extends LeetCodeTask<ListNode> {
    public static final int NUMBER = 5_000;
    public static final int VALUE = 1_000;
    private ListNode head;
    private int group;

    public static final String INFORMATION = """

        Description:
            Given the head of a linked list, reverse the nodes
            of the list k at a time, and return the modified list.

            k is a positive integer and is less than or equal
            to the length of the linked list. If the number of nodes
            is not a multiple of k then left-out nodes, in the end,
            should remain as it is.

            You may not alter the values in the list's nodes,
            only nodes themselves may be changed.

        Example:
            Input: head = [1,2,3,4,5], k = 2
            Output: [2,1,4,3,5]""";

    public ReverseNodesInKGroup(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(NUMBER, VALUE);
        this.group = ThreadLocalRandom.current().nextInt(1, ListNode.size(head));

        log.info("Head is {}", head);
        log.info("Group is {}", group);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1089 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone(), group);
        return original.process();
    }

    // time = 1225 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone(), group);
        return practice.process();
    }

    // time = 942 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone(), group);
        return solution.process();
    }
}
