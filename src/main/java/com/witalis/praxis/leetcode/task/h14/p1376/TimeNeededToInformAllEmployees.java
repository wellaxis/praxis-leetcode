package com.witalis.praxis.leetcode.task.h14.p1376;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1376.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1376,
    description = "Time Needed to Inform All Employees",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TREE, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class TimeNeededToInformAllEmployees extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int SIZE = 1_000;

    private int employees;
    private int headIdentifier;
    private int[] managers;
    private int[] informTimes;

    public static final String INFORMATION = """

        Description:
            A company has n employees with a unique ID for each employee from 0 to n - 1.
                The head of the company is the one with headID.

            Each employee has one direct manager given in the manager array where manager[i]
                is the direct manager of the i-th employee, manager[headID] = -1.
                Also, it is guaranteed that the subordination relationships have a tree structure.

            The head of the company wants to inform all the company employees of an urgent piece of news.
                He will inform his direct subordinates, and they will inform their subordinates,
                and so on until all employees know about the urgent news.

            The i-th employee needs informTime[i] minutes to inform all of his direct subordinates
                (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

            Return the number of minutes needed to inform all the employees about the urgent news.

        Example:
            Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
            Output: 1
            Explanation: The head of the company with id = 2 is the direct manager of all the employees
                in the company and needs 1 minute to inform them all.
                The tree structure of the employees in the company is shown.""";

    public TimeNeededToInformAllEmployees(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.employees = random.nextInt(1, LEN + 1);
        this.headIdentifier = random.nextInt(0, employees);
        this.managers = new int[employees];
        this.informTimes = new int[employees];

        final Queue<Integer> queue = new LinkedList<>();
        final List<Integer> seen = new ArrayList<>(IntStream.range(0, employees).boxed().toList());
        Collections.shuffle(seen);

        queue.offer(headIdentifier);
        managers[headIdentifier] = -1;
        seen.remove((Integer) headIdentifier);

        while (!queue.isEmpty() && !seen.isEmpty()) {
            int manager = queue.poll();
            int subordinates = random.nextInt(1, seen.size() + 1);
            while (subordinates-- > 0) {
                int subordinate = seen.get(0);
                queue.offer(subordinate);
                managers[subordinate] = manager;
                seen.remove((Integer) subordinate);
            }
        }

        for (int i = 0; i < employees; i++) {
            informTimes[i] = random.nextInt(0, SIZE + 1);
        }

        log.info("Employees: {}", employees);
        log.info("Head ID: {}", headIdentifier);
        log.info("Managers: {}", Arrays.toString(managers));
        log.info("Inform Times: {}", Arrays.toString(informTimes));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 27825 ms
    @Override
    protected Integer original() {
        var original = new Original(employees, headIdentifier, managers, informTimes);
        return original.process();
    }

    // time = 22224 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(employees, headIdentifier, managers, informTimes);
        return practice.process();
    }

    // time = 4030 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(employees, headIdentifier, managers, informTimes);
        return solution.process();
    }
}
