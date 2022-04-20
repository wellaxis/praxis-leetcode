package com.witalis.praxis.leetcode.task.h2.p165;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p165.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 165,
    description = "Compare Version Numbers",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, TWO_POINTERS}
)
public class CompareVersionNumbers extends LeetCodeTask<Integer> {
    public static final int LEN = 500;
    private String version1;
    private String version2;

    public static final String INFORMATION = """

        Given two version numbers, version1 and version2, compare them.

        Version numbers consist of one or more revisions joined by a dot '.'.
            Each revision consists of digits and may contain leading zeros.
            Every revision contains at least one character.
            Revisions are 0-indexed from left to right,
            with the leftmost revision being revision 0,
            the next revision being revision 1, and so on.
            For example 2.5.33 and 0.1 are valid version numbers.

        To compare version numbers, compare their revisions in left-to-right order.
            Revisions are compared using their integer value ignoring any leading zeros.
            This means that revisions 1 and 001 are considered equal.
            If a version number does not specify a revision at an index, then treat the revision as 0.
            For example, version 1.0 is less than version 1.1 because their revision 0s are the same,
            but their revision 1s are 0 and 1 respectively, and 0 < 1.

        Return the following:
            * If version1 < version2, return -1.
            * If version1 > version2, return 1.
            * Otherwise, return 0.

        Example:
            Input: version1 = "0.1", version2 = "1.1"
            Output: -1
            Explanation:
                version1's revision 0 is "0", while version2's revision 0 is "1".
                0 < 1, so version1 < version2.""";

    public CompareVersionNumbers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.version1 = generateVersion(random.nextInt(1, 100));
        this.version2 = generateVersion(random.nextInt(1, 100));

        log.info("Version #1 is '{}'", version1);
        log.info("Version #2 is '{}'", version2);
    }

    private String generateVersion(int revisions) {
        var random = ThreadLocalRandom.current();

        StringBuilder version = new StringBuilder();
        while (version.length() < LEN && revisions > 0) {
            if (version.length() > 0) version.append('.');
            if (random.nextInt(0, 10) <= 2) {
                version.append("0".repeat(random.nextInt(1, 5)));
            }
            int revision = random.nextInt(0, Integer.MAX_VALUE);
            version.append(revision);
            revisions--;
        }
        return version.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 492 ms
    @Override
    protected Integer original() {
        var original = new Original(version1, version2);
        return original.process();
    }

    // time = 446 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(version1, version2);
        return practice.process();
    }

    // time = 398 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(version1, version2);
        return solution.process();
    }
}
