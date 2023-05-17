package com.witalis.praxis.leetcode.task.h22.p2130;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h22.p2130.content.*;
import com.witalis.praxis.leetcode.task.h22.p2130.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2130,
    description = "Maximum Twin Sum of a Linked List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TWO_POINTERS, STACK}
)
public class MaximumTwinSumOfLinkedList extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private ListNode head;

    public static final String INFORMATION = """

        Description:
            In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list
                is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

            * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2.
                These are the only nodes with twins for n = 4.

            The twin sum is defined as the sum of a node and its twin.

            Given the head of a linked list with even length, return the maximum twin sum of the linked list.

        Example:
            Input: head = [4,2,2,3]
            Output: 7
            Explanation:
                The nodes with twins present in this linked list are:
                - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
                - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
                Thus, the maximum twin sum of the linked list is max(7, 4) = 7.\s""";

    public MaximumTwinSumOfLinkedList(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE / 2);

        log.info("Head: {}", head);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 10193 ms
    @Override
    protected Integer original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 7393 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 3069 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
