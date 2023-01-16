package com.witalis.praxis.leetcode.task.h11.p1061;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1061.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1061,
    description = "Lexicographically Smallest Equivalent String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, UNION_FIND}
)
public class LexicographicallySmallestEquivalentString extends LeetCodeTask<String> {
    public static final int LEN = 1_000;
    private String string1;
    private String string2;
    private String stringBase;

    public static final String INFORMATION = """

        Description:
            You are given two strings of the same length s1 and s2 and a string baseStr.
      
            We say s1[i] and s2[i] are equivalent characters.
                * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.

            Equivalent characters follow the usual rules of any equivalence relation:
                * Reflexivity: 'a' == 'a'.
                * Symmetry: 'a' == 'b' implies 'b' == 'a'.
                * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.

            For example, given the equivalency information from s1 = "abc" and s2 = "cde",
                "acd" and "aab" are equivalent strings of baseStr = "eed",
                and "aab" is the lexicographically smallest equivalent string of baseStr.

            Return the lexicographically smallest equivalent string of baseStr
                by using the equivalency information from s1 and s2.

        Example:
            Input: s1 = "hello", s2 = "world", baseStr = "hold"
            Output: "hdld"
            Explanation: Based on the equivalency information in s1 and s2,
                we can group their characters as [h,w], [d,e,o], [l,r].
                So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".""";

    public LexicographicallySmallestEquivalentString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        this.string1 = generate(len);
        this.string2 = generate(len);

        len = random.nextInt(1, LEN + 1);
        this.stringBase = generate(len);


        log.info("String 's1' is {}", string1);
        log.info("String 's2' is {}", string2);
        log.info("String 'base' is {}", stringBase);
    }

    private static String generate(int len) {
        final var random = ThreadLocalRandom.current();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7603 ms
    @Override
    protected String original() {
        var original = new Original(string1, string2, stringBase);
        return original.process();
    }

    // time = 7216 ms
    @Override
    protected String practice() {
        var practice = new Practice(string1, string2, stringBase);
        return practice.process();
    }

    // time = 1349 ms
    @Override
    protected String solution() {
        var solution = new Solution(string1, string2, stringBase);
        return solution.process();
    }
}
