package com.witalis.praxis.leetcode.task.h11.p1021;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1021.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1021,
    description = "Remove Outermost Parentheses",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, STACK}
)
public class RemoveOutermostParentheses extends LeetCodeTask<String> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            A valid parentheses string is either empty "", "(" + A + ")", or A + B,
                where A and B are valid parentheses strings, and + represents string concatenation.

            * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

            A valid parentheses string s is primitive if it is nonempty, and there does not exist a way
                to split it into s = A + B, with A and B nonempty valid parentheses strings.

            Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk,
                where Pi are primitive valid parentheses strings.

            Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

        Example:
            Input: s = "(()())(())(()(()))"
            Output: "()()()()(())"
            Explanation:
                The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
                After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".""";

    public RemoveOutermostParentheses(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        while (len > 0) {
            String s = generate();
            builder.append(s);
            len -= s.length();
        }
        this.string = builder.toString();

        log.info("String 's': '{}'", string);
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        var builder = new StringBuilder();

        int outer = random.nextInt(0, 6);
        int inner = random.nextInt(0, 6);
        builder.append("(".repeat(outer));
        builder.append("()".repeat(inner));
        builder.append(")".repeat(outer));

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5845 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 5792 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 5634 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
