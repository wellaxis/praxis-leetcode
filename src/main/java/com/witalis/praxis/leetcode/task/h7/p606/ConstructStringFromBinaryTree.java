package com.witalis.praxis.leetcode.task.h7.p606;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p606.content.*;
import com.witalis.praxis.leetcode.task.h7.p606.option.*;
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
    id = 606,
    description = "Construct String from Binary Tree",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, TREE, BINARY_TREE, DEPTH_FIRST_SEARCH}
)
public class ConstructStringFromBinaryTree extends LeetCodeTask<String> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000;
    private TreeNode root;

    public static final String INFORMATION = """

        Given the root of a binary tree, construct a string consisting of parenthesis
            and integers from a binary tree with the preorder traversal way, and return it.

        Omit all the empty parenthesis pairs that do not affect the one-to-one mapping
            relationship between the string and the original binary tree.

        Example:
            Input: root = [1,2,3,4]
            Output: "1(2(4))(3)"
            Explanation: Originally, it needs to be "1(2(4)())(3()())",
                but you need to omit all the unnecessary empty parenthesis pairs.
                And it will be "1(2(4))(3)""";

    public ConstructStringFromBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                values.add(null);
            } else {
                values.add(random.nextInt(-VALUE, VALUE + 1));
            }
        }
        var tree = values.toArray(Integer[]::new);
        this.root = TreeNode.initTree(tree, new TreeNode(), 0);

        log.info("Root: {}", root.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1002 ms
    @Override
    protected String original() {
        var original = new Original(root);
        return original.process();
    }

    // time = 851 ms
    @Override
    protected String practice() {
        var practice = new Practice(root);
        return practice.process();
    }

    // time = 1145 ms
    @Override
    protected String solution() {
        var solution = new Solution(root);
        return solution.process();
    }
}
