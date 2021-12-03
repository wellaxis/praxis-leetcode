package com.witalis.praxis.leetcode.task.p21;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p21.content.*;
import com.witalis.praxis.leetcode.task.p21.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LeetCode(id = 21, description = "Merge Two Sorted Lists")
public class MergeTwoSortedLists extends LeetCodeTask<ListNode> {
    public static final int NUMBER = 51;

    private ListNode l1;
    private ListNode l2;

    public static final String INFORMATION = """

        Description:
            Merge two sorted linked lists and return it as a sorted list.
            The list should be made by splicing together the nodes of the first two lists.
        Example:
            Input: l1 = [1,2,4], l2 = [1,3,4]
            Output: [1,1,2,3,4,4]""";

    public MergeTwoSortedLists(int id, String description, TaskRevision revision) {
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

    // time = 657 ms
    @Override
    protected ListNode original() {
        var original = new Original(l1.clone(), l2.clone());
        return original.process();
    }

    // time = 461 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(l1.clone(), l2.clone());
        return practice.process();
    }

    // time = 450 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(l1.clone(), l2.clone());
        return solution.process();
    }
}
