package com.witalis.praxis.leetcode.task.h3.p222;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p222.content.*;
import com.witalis.praxis.leetcode.task.h3.p222.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 222,
    description = "Count Complete Tree Nodes",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH, DEPTH_FIRST_SEARCH}
)
public class CountCompleteTreeNodes extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = 50_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a complete binary tree, return the number of the nodes in the tree.

        According to Wikipedia, every level, except possibly the last, is completely filled
            in a complete binary tree, and all nodes in the last level are as far left as possible.
            It can have between 1 and 2h nodes inclusive at the last level h.

        Design an algorithm that runs in less than O(n) time complexity.

        Example:
            Input: root = [1,2,3,4,5,6]
            Output: 6""";

    public CountCompleteTreeNodes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);
        List<Integer> values = IntStream.rangeClosed(0, len).map(i -> i + 1).boxed().toList();
        var tree = values.toArray(Integer[]::new);
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1295 ms
    @Override
    protected Integer original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1019 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 671 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
