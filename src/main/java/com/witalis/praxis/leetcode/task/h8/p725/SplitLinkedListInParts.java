package com.witalis.praxis.leetcode.task.h8.p725;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p725.content.*;
import com.witalis.praxis.leetcode.task.h8.p725.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 725,
    description = "Split Linked List in Parts",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST}
)
public class SplitLinkedListInParts extends LeetCodeTask<ListNode[]> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;
    public static final int PARTS = 50;

    private ListNode head;
    private int parts;

    public static final String INFORMATION = """

        Description:
            Given the head of a singly linked list and an integer k,
                split the linked list into k consecutive linked list parts.

            The length of each part should be as equal as possible: no two parts should have a size differing by more than one.
                This may lead to some parts being null.

            The parts should be in the order of occurrence in the input list,
                and parts occurring earlier should always have a size greater than or equal to parts occurring later.

            Return an array of the k parts.

        Example:
            Input: head = [1,2,3], k = 5
            Output: [[1],[2],[3],[],[]]
            Explanation:
                The first element output[0] has output[0].val = 1, output[0].next = null.
                The last element output[4] is null, but its string representation as a ListNode is [].""";

    public SplitLinkedListInParts(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);
        this.parts = ThreadLocalRandom.current().nextInt(1, PARTS + 1);

        log.info("List head: {}", head);
        log.info("Parts k: {}", parts);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 610 ms
    @Override
    protected ListNode[] original() {
        var original = new Original(head.clone(), parts);
        return original.process();
    }

    // time = 568 ms
    @Override
    protected ListNode[] practice() {
        var practice = new Practice(head.clone(), parts);
        return practice.process();
    }

    // time = 661 ms
    @Override
    protected ListNode[] solution() {
        var solution = new Solution(head.clone(), parts);
        return solution.process();
    }
}
