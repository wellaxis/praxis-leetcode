package com.witalis.praxis.leetcode.task.h13.p1282;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1282.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1282,
    description = "Group the People Given the Group Size They Belong To",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE}
)
public class GroupPeopleGivenGroupSizeTheyBelongTo extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 500;

    private int[] groupSizes;

    public static final String INFORMATION = """

        Description:
            There are n people that are split into some unknown number of groups.
                Each person is labeled with a unique ID from 0 to n - 1.

            You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in.
                For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.

            Return a list of groups such that each person i is in a group of size groupSizes[i].

            Each person should appear in exactly one group, and every person must be in a group.
                If there are multiple answers, return any of them.
                It is guaranteed that there will be at least one valid solution for the given input.

        Example:
            Input: groupSizes = [3,3,3,3,3,1,3]
            Output: [[5],[0,1,2],[3,4,6]]
            Explanation:
                The first group is [5]. The size is 1, and groupSizes[5] = 1.
                The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
                The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
                Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].""";

    public GroupPeopleGivenGroupSizeTheyBelongTo(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.groupSizes = random.ints(
            random.nextInt(1, LEN + 1),
            1, LEN + 1
        ).toArray();

        log.info("Group sizes: {}", Arrays.toString(groupSizes));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 972 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(groupSizes);
        return original.process();
    }

    // time = 854 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(groupSizes);
        return practice.process();
    }

    // time = 778 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(groupSizes);
        return solution.process();
    }
}
