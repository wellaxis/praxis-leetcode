package com.witalis.praxis.leetcode.task.h6.p590;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p590.content.*;
import com.witalis.praxis.leetcode.task.h6.p590.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 590,
    description = "N-ary Tree Postorder Traversal",
    difficulty = TaskDifficulty.EASY,
    tags = {STACK, TREE, DEPTH_FIRST_SEARCH}
)
public class NaryTreePostorderTraversal extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;
    private Node root;

    public static final String INFORMATION = """

        Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

        Nary-Tree input serialization is represented in their level order traversal.
            Each group of children is separated by the null value (See examples).

        Example:
            Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
            Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]""";

    public NaryTreePostorderTraversal(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.root = Node.initTree(LEN, VALUE);
        log.info("Root: {}", root);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2865 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 6047 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 2667 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
