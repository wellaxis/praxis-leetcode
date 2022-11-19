package com.witalis.praxis.leetcode.task.h4.p331;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p331.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 331,
    description = "Verify Preorder Serialization of a Binary Tree",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, STACK, TREE, BINARY_TREE}
)
public class VerifyPreorderSerializationOfBinaryTree extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100;
    private String preorder;

    public static final String INFORMATION = """

        Description:
            One way to serialize a binary tree is to use preorder traversal.
                When we encounter a non-null node, we record the node's value.
                If it is a null node, we record using a sentinel value such as '#'.

            For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
                where '#' represents a null node.

            Given a string of comma-separated values preorder,
                return true if it is a correct preorder traversal serialization of a binary tree.

            It is guaranteed that each comma-separated value in the string
                must be either an integer or a character '#' representing null pointer.

            You may assume that the input format is always valid.
            * For example, it could never contain two consecutive commas, such as "1,,3".

            Note: You are not allowed to reconstruct the tree.

        Example:
            Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
            Output: true""";

    public VerifyPreorderSerializationOfBinaryTree(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 10) == 0) {
                builder.append('#');
            } else {
                builder.append(random.nextInt(0, VALUE + 1));
            }
            builder.append(',');
        }
        this.preorder = builder.substring(0, builder.length() - 1);

        log.info("Preorder is '{}'", preorder);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3625 ms
    @Override
    protected Boolean original() {
        var original = new Original(preorder);
        return original.process();
    }

    // time = 3342 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(preorder);
        return practice.process();
    }

    // time = 2158 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(preorder);
        return solution.process();
    }
}
