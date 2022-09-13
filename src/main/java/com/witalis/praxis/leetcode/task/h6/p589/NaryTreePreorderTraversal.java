package com.witalis.praxis.leetcode.task.h6.p589;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p589.content.*;
import com.witalis.praxis.leetcode.task.h6.p589.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 589,
    description = "N-ary Tree Preorder Traversal",
    difficulty = TaskDifficulty.EASY,
    tags = {STACK, TREE, DEPTH_FIRST_SEARCH}
)
public class NaryTreePreorderTraversal extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;
    private Node root;

    public static final String INFORMATION = """

        Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

        Nary-Tree input serialization is represented in their level order traversal.
            Each group of children is separated by the null value (See examples).

        Example:
            Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
            Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]""";

    public NaryTreePreorderTraversal(int id, String description, TaskRevision revision) {
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

    // time = 2407 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 5747 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 2527 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
