package com.witalis.praxis.leetcode.task.h1.p61;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p61.content.*;
import com.witalis.praxis.leetcode.task.h1.p61.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 61,
    description = "Rotate List",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TWO_POINTERS}
)
public class RotateList extends LeetCodeTask<ListNode> {
    public static final int LEN = 500;
    public static final int VALUE = 100;
    public static final int MAX = 2 * (int) Math.pow(10, 9);
    private ListNode head;
    private int rotation;

    public static final String INFORMATION = """

        Given the head of a linked list,
            rotate the list to the right by k places.

        Example:
            Input: head = [1,2,3,4,5], k = 2
            Output: [4,5,1,2,3]""";

    public RotateList(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);
        this.rotation = ThreadLocalRandom.current().nextInt(0, MAX + 1);

        log.info("Head is {}", head);
        log.info("Rotation is {}", rotation);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2547291 ms, time limit exceeded
    @Override
    protected ListNode original() {
        var original = new Original(head.clone(), rotation);
        return original.process();
    }

    // time = 667 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(head.clone(), rotation);
        return practice.process();
    }

    // time = 490 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(head.clone(), rotation);
        return solution.process();
    }
}
