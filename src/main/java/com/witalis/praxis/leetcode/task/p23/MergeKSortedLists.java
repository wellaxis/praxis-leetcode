package com.witalis.praxis.leetcode.task.p23;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p23.content.*;
import com.witalis.praxis.leetcode.task.p23.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 23, description = "Merge k Sorted Lists")
public class MergeKSortedLists extends LeetCodeTask<ListNode> {
    public static final int SIZE = 1000;
    public static final int VALUE = 1000;
    public static final int LEN = 500;

    private ListNode[] lists;

    public static final String INFORMATION = """

        Description:
            You are given an array of k linked-lists lists,
            each linked-list is sorted in ascending order.
        Merge all the linked-lists into one sorted linked-list and return it.

        Example:
            Input: lists = [[1,4,5],[1,3,4],[2,6]]
            Output: [1,1,2,3,4,4,5,6]
            Explanation: The linked-lists are:
            [
              1->4->5,
              1->3->4,
              2->6
            ]
            merging them into one sorted list:
            1->1->2->3->4->4->5->6""";

    public MergeKSortedLists(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int k = random.nextInt(0, SIZE + 1);
        this.lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            lists[i] = ListNode.initRandom(LEN, VALUE);
        }

        log.info("K is {}, nodes are {}", k, lists);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4249947 ms
    @Override
    protected ListNode original() {
        var original = new Original(lists.clone());
        return original.process();
    }

    // time = 284853 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(lists.clone());
        return practice.process();
    }

    // time = 369986 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(lists.clone());
        return solution.process();
    }
}
