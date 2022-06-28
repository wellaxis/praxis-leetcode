package com.witalis.praxis.leetcode.task.h2.p138;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p138.content.*;
import com.witalis.praxis.leetcode.task.h2.p138.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 138,
    description = "Copy List with Random Pointer",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, LINKED_LIST}
)
public class CopyListWithRandomPointer extends LeetCodeTask<Node> {
    public static final int LEN = 1_000;
    public static final int VALUE = 10_000;
    private Node head;

    public static final String INFORMATION = """

        A linked list of length n is given such that each node contains an additional random pointer,
            which could point to any node in the list, or null.

        Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
            where each new node has its value set to the value of its corresponding original node.
            Both the next and random pointer of the new nodes should point to new nodes in the copied list
            such that the pointers in the original list and copied list represent the same list state.
            None of the pointers in the new list should point to nodes in the original list.

        For example, if there are two nodes X and Y in the original list, where X.random --> Y,
            then for the corresponding two nodes x and y in the copied list, x.random --> y.

        Return the head of the copied linked list.

        The linked list is represented in the input/output as a list of n nodes.
            Each node is represented as a pair of [val, random_index] where:
            * val: an integer representing Node.val
            * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
              or null if it does not point to any node.

        Your code will only be given the head of the original linked list.

        Example:
            Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
            Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]""";

    public CopyListWithRandomPointer(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);
        int[][] nodes = new int[len][2];

        for (int i = 0; i < len; i++) {
            nodes[i][0] = random.nextInt(-VALUE, VALUE + 1);
            if (random.nextInt(0, 4) == 0) {
                nodes[i][1] = -1;
            } else {
                nodes[i][1] = random.nextInt(0, len);
            }
        }

        this.head = Node.initList(nodes);
        log.info("Head: {}", head.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 748 ms
    @Override
    protected Node original() {
        var original = new Original(head);
        return original.process();
    }

    // time = 1152 ms
    @Override
    protected Node practice() {
        var practice = new Practice(head);
        return practice.process();
    }

    // time = 439 ms
    @Override
    protected Node solution() {
        var solution = new Solution(head);
        return solution.process();
    }
}
