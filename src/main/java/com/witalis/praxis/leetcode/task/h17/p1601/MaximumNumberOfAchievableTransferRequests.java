package com.witalis.praxis.leetcode.task.h17.p1601;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1601.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1601,
    description = "Maximum Number of Achievable Transfer Requests",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BACKTRACKING, BIT_MANIPULATION, ENUMERATION}
)
public class MaximumNumberOfAchievableTransferRequests extends LeetCodeTask<Integer> {
    public static final int SIZE = 20;
    public static final int LEN = 16;

    private int buildings;
    private int[][] requests;

    public static final String INFORMATION = """

        Description:
            We have n buildings numbered from 0 to n - 1. Each building has a number of employees.
                It's transfer season, and some employees want to change the building they reside in.

            You are given an array requests where requests[i] = [fromi, toi] represents
                an employee's request to transfer from building fromi to building toi.

            All buildings are full, so a list of requests is achievable only if for each building,
                the net change in employee transfers is zero. This means the number of employees leaving
                is equal to the number of employees moving in.
                For example if n = 3 and two employees are leaving building 0, one is leaving building 1,
                and one is leaving building 2, there should be two employees moving to building 0,
                one employee moving to building 1, and one employee moving to building 2.

            Return the maximum number of achievable requests.

        Example:
            Input: n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
            Output: 5
            Explanation: Let's see the requests:
                From building 0 we have employees x and y and both want to move to building 1.
                From building 1 we have employees a and b and they want to move to buildings 2 and 0 respectively.
                From building 2 we have employee z and they want to move to building 0.
                From building 3 we have employee c and they want to move to building 4.
                From building 4 we don't have any requests.
                We can achieve the requests of users x and b by swapping their places.
                We can achieve the requests of users y, a and z by swapping the places in the 3 buildings.""";

    public MaximumNumberOfAchievableTransferRequests(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.buildings = random.nextInt(1, SIZE + 1);
        int len = random.nextInt(1, LEN + 1);
        this.requests = new int[len][2];
        for (int i = 0; i < len; i++) {
            requests[i] = new int[] {
                random.nextInt(0, buildings),
                random.nextInt(0, buildings)
            };
        }

        log.info("Buildings: {}", buildings);
        log.info("Requests: {}", Arrays.deepToString(requests));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 611 ms
    @Override
    protected Integer original() {
        var original = new Original(buildings, requests);
        return original.process();
    }

    // time = 495 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(buildings, requests);
        return practice.process();
    }

    // time = 441 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(buildings, requests);
        return solution.process();
    }
}
