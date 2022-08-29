package com.witalis.praxis.leetcode.task.h6.p559;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p559.content.*;
import com.witalis.praxis.leetcode.task.h6.p559.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 559,
    description = "Maximum Depth of N-ary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class MaximumDepthOfNaryTree extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int DEPTH = 1_000;
    private Node root;

    public static final String INFORMATION = """

        Given a n-ary tree, find its maximum depth.

        The maximum depth is the number of nodes along the longest path
            from the root node down to the farthest leaf node.

        Nary-Tree input serialization is represented in their level order traversal,
            each group of children is separated by the null value (See examples).

        Example:
            Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
            Output: 5""";

    public MaximumDepthOfNaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = Node.initGraph(LEN);
        log.info("Node: {}", root);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4566 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1543 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 1477 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
