package com.witalis.praxis.leetcode.task.h9.p830;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p830.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 830,
    description = "Positions of Large Groups",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class PositionsOfLargeGroups extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 1_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            In a string s of lowercase letters, these letters form consecutive groups of the same character.

            For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

            A group is identified by an interval [start, end], where start and end denote the start and end indices
                (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].

            A group is considered large if it has 3 or more characters.

            Return the intervals of every large group sorted in increasing order by start index.

        Example:
            Input: s = "abcdddeeeeaabbbcd"
            Output: [[3,5],[6,9],[12,14]]
            Explanation: The large groups are "ddd", "eeee", and "bbb".""";

    public PositionsOfLargeGroups(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var builder = new StringBuilder();
        int len = random.nextInt(1, LEN + 1);
        for (int j = 0; j < len; j++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String s: '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 677 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 513 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 507 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
