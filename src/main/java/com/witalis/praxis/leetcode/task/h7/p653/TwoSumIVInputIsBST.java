package com.witalis.praxis.leetcode.task.h7.p653;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p653.content.*;
import com.witalis.praxis.leetcode.task.h7.p653.option.*;
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
    id = 653,
    description = "Two Sum IV - Input is a BST",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, HASH_TABLE, TWO_POINTERS}
)
public class TwoSumIVInputIsBST extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;
    public static final int RANGE = 100_000;
    private TreeNode root;
    private int target;

    public static final String INFORMATION = """

        Given the root of a Binary Search Tree and a target number k,
            return true if there exist two elements in the BST such that their sum is equal to the given target.

        Example:
            Input: root = [5,3,6,2,4,null,7], k = 9
            Output: true""";

    public TwoSumIVInputIsBST(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        int counter = 0;
        while (counter <= len) {
            values.add(random.nextInt(-VALUE, VALUE + 1));
            counter++;
        }
        var tree = values.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
        this.root = TreeNode.initTree(tree);
        this.target = random.nextInt(-RANGE, RANGE + 1);

        log.info("Root: {}", root.toString());
        log.info("Target is {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1467 ms
    @Override
    protected Boolean original() {
        var original = new Original(root, target);
        return original.process();
    }

    // time = 1185 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(root, target);
        return practice.process();
    }

    // time = 1252 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(root, target);
        return solution.process();
    }
}
