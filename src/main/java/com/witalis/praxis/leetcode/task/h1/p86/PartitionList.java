package com.witalis.praxis.leetcode.task.h1.p86;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p86.content.*;
import com.witalis.praxis.leetcode.task.h1.p86.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 86,
    description = "Partition List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TWO_POINTERS}
)
public class PartitionList extends LeetCodeTask<ListNode> {
    public static final int LEN = 200;
    public static final int VALUE = 100;
    private ListNode head;
    private int x;

    public static final String INFORMATION = """

            Given the head of a linked list and a value x,
                partition it such that all nodes less than x
                come before nodes greater than or equal to x.

            You should preserve the original relative order
                of the nodes in each of the two partitions.

            Example:
                Input: head = [1,4,3,2,5,2], x = 3
                Output: [1,2,2,4,3,5]""";

    public PartitionList(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);
        this.x = ThreadLocalRandom.current().nextInt(-VALUE, VALUE + 1);

        log.info("Head is {}", head);
        log.info("Value is {}", x);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 438 ms
    @Override
    protected ListNode original() {
        var original = new Original(head.clone(), x);
        return original.process();
    }

    // time = 383 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone(), x);
        return practice.process();
    }

    // time = 334 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone(), x);
        return solution.process();
    }
}
