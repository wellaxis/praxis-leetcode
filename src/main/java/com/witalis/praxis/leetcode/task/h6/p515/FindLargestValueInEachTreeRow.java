package com.witalis.praxis.leetcode.task.h6.p515;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p515.content.*;
import com.witalis.praxis.leetcode.task.h6.p515.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 515,
    description = "Find Largest Value in Each Tree Row",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, BINARY_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class FindLargestValueInEachTreeRow extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;

    private TreeNode root;

    public static final String INFORMATION = """

        Description:
            Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

        Example:
            Input: root = [1,3,2,5,3,null,9]
            Output: [1,3,9]""";

    public FindLargestValueInEachTreeRow(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);
        List<Integer> values = new ArrayList<>();
        int counter = 0;
        while (counter++ <= len)
            values.add(random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
        var tree = values.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        this.root = TreeNode.initTree(tree);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1249 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 1127 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 966 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
