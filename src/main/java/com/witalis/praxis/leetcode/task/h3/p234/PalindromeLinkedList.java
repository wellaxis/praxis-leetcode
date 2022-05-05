package com.witalis.praxis.leetcode.task.h3.p234;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p234.content.*;
import com.witalis.praxis.leetcode.task.h3.p234.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 234,
    description = "Palindrome Linked List",
    difficulty = TaskDifficulty.EASY,
    tags = {LINKED_LIST, TWO_POINTERS, STACK, RECURSION}
)
public class PalindromeLinkedList extends LeetCodeTask<Boolean> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10;

    private ListNode head;

    public static final String INFORMATION = """

        Given the head of a singly linked list, return true if it is a palindrome.

        Example:
            Input: head = [1,2,2,1]
            Output: true""";

    public PalindromeLinkedList(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.head = ListNode.initList(LEN, VALUE);

        log.info("Node is {}", head);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 9344 ms
    @Override
    protected Boolean original() {
        var original = new Original(head.clone());
        return original.process();
    }

    // time = 2185 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(head.clone());
        return practice.process();
    }

    // time = 2208 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(head.clone());
        return solution.process();
    }
}
