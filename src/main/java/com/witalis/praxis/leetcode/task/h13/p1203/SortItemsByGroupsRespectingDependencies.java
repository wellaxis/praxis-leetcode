package com.witalis.praxis.leetcode.task.h13.p1203;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1203.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1203,
    description = "Sort Items by Groups Respecting Dependencies",
    difficulty = TaskDifficulty.HARD,
    tags = {GRAPH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, TOPOLOGICAL_SORT}
)
public class SortItemsByGroupsRespectingDependencies extends LeetCodeTask<int[]> {
    public static final int LEN = 3_000;

    private int items;
    private int groups;
    private int[] belongGroup;
    private List<List<Integer>> beforeItems;

    public static final String INFORMATION = """

        Description:
            There are n items each belonging to zero or one of m groups where group[i] is the group
                that the i-th item belongs to and it's equal to -1 if the i-th item belongs to no group.
                The items and the groups are zero indexed. A group can have no item belonging to it.

            Return a sorted list of the items such that:
                * The items that belong to the same group are next to each other in the sorted list.
                * There are some relations between these items where beforeItems[i] is a list containing all the items
                  that should come before the i-th item in the sorted array (to the left of the i-th item).

            Return any solution if there is more than one solution and return an empty list if there is no solution.

        Example:
            Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
            Output: [6,3,4,1,5,2,0,7]""";

    public SortItemsByGroupsRespectingDependencies(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.items = random.nextInt(1, LEN + 1);
        this.groups = random.nextInt(1, items + 1);
        this.belongGroup = random.ints(
            items, -1, groups
        ).toArray();
        this.beforeItems = new ArrayList<>(items);
        for (int i = 0; i < items; i++) {
            int size = random.nextInt(0, items);
            Set<Integer> elements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                int element = random.nextInt(0, items);
                if (element != i) {
                    elements.add(element);
                }
            }
            beforeItems.add(i, new ArrayList<>(elements));
        }

        log.info("Items n: {}", items);
        log.info("Groups m: {}", groups);
        log.info("Belong group: {}", Arrays.toString(belongGroup));
        log.info("Before items: {}", beforeItems);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // dfs, time = 14816 ms
    @Override
    protected int[] original() {
        var original = new Original(items, groups, belongGroup, beforeItems);
        return original.process();
    }

    // dfs, time = 14587 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(items, groups, belongGroup, beforeItems);
        return practice.process();
    }

    // bfs, time = 12285 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(items, groups, belongGroup, beforeItems);
        return solution.process();
    }
}
