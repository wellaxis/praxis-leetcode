package com.witalis.praxis.leetcode.task.h2.p160;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p160.content.*;
import com.witalis.praxis.leetcode.task.h2.p160.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 160,
    description = "Intersection of Two Linked Lists",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, LINKED_LIST, TWO_POINTERS}
)
public class IntersectionOfTwoLinkedLists extends LeetCodeTask<ListNode> {
    public static final int LEN = 30_000;
    public static final int VALUE = 100_000;

    private ListNode headA;
    private ListNode headB;

    public static final String INFORMATION = """

        Given the heads of two singly linked-lists headA and headB,
            return the node at which the two lists intersect.
            If the two linked lists have no intersection at all, return null.

        For example, the following two linked lists begin to intersect at node c1:
            A:       a1 -> a2 \\
                                c1 -> c2 -> c3
            B: b1 -> b2 -> b3 /

        The test cases are generated such that
            there are no cycles anywhere in the entire linked structure.

        Note that the linked lists must retain their original structure
            after the function returns.

        Custom Judge:
                
        The inputs to the judge are given as follows
            (your program is not given these inputs):

        * intersectVal - The value of the node where the intersection occurs.
                         This is 0 if there is no intersected node.
        * listA - The first linked list.
        * listB - The second linked list.
        * skipA - The number of nodes to skip ahead in listA
                  (starting from the head) to get to the intersected node.
        * skipB - The number of nodes to skip ahead in listB
                  (starting from the head) to get to the intersected node.

        The judge will then create the linked structure based on these inputs
            and pass the two heads, headA and headB to your program.
            If you correctly return the intersected node,
            then your solution will be accepted.

        Example:
            Input:
                intersectVal = 8,
                listA = [4,1,8,4,5],
                listB = [5,6,1,8,4,5],
                skipA = 2,
                skipB = 3
            Output:
                Intersected at '8'
            Explanation:
                The intersected node's value is 8
                (note that this must not be 0 if the two lists intersect).
                From the head of A, it reads as [4,1,8,4,5].
                From the head of B, it reads as [5,6,1,8,4,5].
                There are 2 nodes before the intersected node in A;
                There are 3 nodes before the intersected node in B.""";

    public IntersectionOfTwoLinkedLists(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        ListNode intersect = null;
        if (ThreadLocalRandom.current().nextBoolean()) {
            intersect = ListNode.initList(LEN, VALUE, null);
        }

        this.headA = ListNode.initList(LEN, VALUE, intersect);
        this.headB = ListNode.initList(LEN, VALUE, intersect);

        log.info("Node Intersect is {}", intersect);
        log.info("Node A is {}", headA);
        log.info("Node B is {}", headB);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3233 ms
    @Override
    protected ListNode original() {
        var original = new Original(headA, headB);
        return original.process();
    }

    // time = 1079 ms
    @Override
    protected ListNode practice() {
        var practice = new Practice(headA, headB);
        return practice.process();
    }

    // time = 907 ms
    @Override
    protected ListNode solution() {
        var solution = new Solution(headA, headB);
        return solution.process();
    }
}
