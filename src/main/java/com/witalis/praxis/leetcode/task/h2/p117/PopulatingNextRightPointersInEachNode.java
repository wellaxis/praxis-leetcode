package com.witalis.praxis.leetcode.task.h2.p117;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p117.content.*;
import com.witalis.praxis.leetcode.task.h2.p117.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 117,
    description = "Populating Next Right Pointers in Each Node II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {LINKED_LIST, TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class PopulatingNextRightPointersInEachNode extends LeetCodeTask<Node> {
    public static final int HEIGHT = 12;
    private Node root;

    public static final String INFORMATION = """

        Given a binary tree:
                                                          
            struct Node {
                int val;
                Node *left;
                Node *right;
                Node *next;
            }

        Populate each next pointer to point to its next right node.
            If there is no next right node, the next pointer should be set to NULL.

        Initially, all next pointers are set to NULL.

        Example:
            Input: root = [1,2,3,4,5,null,7]
            Output: [1,#,2,3,#,4,5,7,#]
            Explanation: Given the above binary tree (Figure A),
                your function should populate each next pointer to point to its next right node,
                just like in Figure B. The serialized output is in level order as connected by the next pointers,
                with '#' signifying the end of each level.""";

    public PopulatingNextRightPointersInEachNode(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        int height = ThreadLocalRandom.current().nextInt(1, HEIGHT + 1);
        this.root = Node.initTree(height);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 716 ms
    @Override
    protected Node original() {
        var original = new Original(Node.cloneTree(root));
        return original.process();
    }

    // time = 660 ms
    @Override
    protected Node practice() {
        var practice = new Practice(Node.cloneTree(root));
        return practice.process();
    }

    // time = 409 ms
    @Override
    protected Node solution() {
        var solution = new Solution(Node.cloneTree(root));
        return solution.process();
    }
}
