package com.witalis.praxis.leetcode.task.h10.p938;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p938.content.*;
import com.witalis.praxis.leetcode.task.h10.p938.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 938,
    description = "Range Sum of BST",
    difficulty = TaskDifficulty.EASY,
    tags = {TREE, BINARY_TREE, BINARY_SEARCH_TREE, DEPTH_FIRST_SEARCH}
)
public class RangeSumOfBST extends LeetCodeTask<Integer> {
    public static final int LEN = 20_000;
    public static final int VALUE = 100_000;

    private TreeNode root;
    private int low;
    private int high;

    public static final String INFORMATION = """

        Description:
            Given the root node of a binary search tree and two integers low and high,
                return the sum of values of all nodes with a value in the inclusive range [low, high].

        Example:
            Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
            Output: 32
            Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.""";

    public RangeSumOfBST(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var tree = random.ints(
                random.nextInt(1, LEN + 1),
                1, VALUE + 1
            )
            .distinct()
            .sorted()
            .boxed()
            .mapToInt(Integer::intValue)
            .toArray();
        this.root = TreeNode.initTree(tree);
        this.low = random.nextInt(1, VALUE + 1);
        this.high = random.nextInt(low, VALUE + 1);

        log.info("Root: {}", root.toString());
        log.info("Low: {}", low);
        log.info("High: {}", high);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1048 ms
    @Override
    protected Integer original() {
        var original = new Original(root, low, high);
        return original.process();
    }

    // time = 2022 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(root, low, high);
        return practice.process();
    }

    // time = 939 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(root, low, high);
        return solution.process();
    }
}
