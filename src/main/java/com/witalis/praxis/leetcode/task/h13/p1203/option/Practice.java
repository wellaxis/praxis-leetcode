package com.witalis.praxis.leetcode.task.h13.p1203.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ID: 1203
 * Name: Sort Items by Groups Respecting Dependencies
 * URL: <a href="https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/">Sort Items by Groups Respecting Dependencies</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Practice {
    private int items;
    private int groups;
    private int[] belongGroup;
    private List<List<Integer>> beforeItems;

    public Practice(int items, int groups, int[] belongGroup, List<List<Integer>> beforeItems) {
        this.items = items;
        this.groups = groups;
        this.belongGroup = belongGroup;
        this.beforeItems = beforeItems;
    }

    public int[] process() {
        return sortItems(items, groups, belongGroup, beforeItems);
    }

    private int[] itemIndegrees;
    private int[] groupIndegrees;

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        if (n <= 0 || m <= 0 || group == null || beforeItems == null) return new int[0];

        final int[] sortedItems = new int[n];

        this.itemIndegrees = new int[n];
        this.groupIndegrees = new int[n];

        final List<Integer>[] groups = constructGroups(n, group);
        final List<Integer>[] graph = constructGraph(n, group, beforeItems);

        int index = 0;
        final Queue<Integer> groupQueue = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (groupIndegrees[i] == 0)
                groupQueue.offer(i);

        while (!groupQueue.isEmpty()) {
            int groupId = groupQueue.poll();
            final List<Integer> itemsInGroup = groups[groupId];

            if (itemsInGroup != null) {
                final Queue<Integer> itemQueue = new LinkedList<>();

                for (int item : itemsInGroup)
                    if (itemIndegrees[item] == 0)
                        itemQueue.offer(item);

                while (!itemQueue.isEmpty()) {
                    int item = itemQueue.poll();
                    sortedItems[index++] = item;

                    if (graph[item] != null) {
                        for (int neighbor : graph[item]) {
                            itemIndegrees[neighbor]--;

                            if (group[neighbor] != groupId) {
                                if (--groupIndegrees[group[neighbor]] == 0)
                                    groupQueue.offer(group[neighbor]);
                            } else if (itemIndegrees[neighbor] == 0) {
                                itemQueue.offer(neighbor);
                            }
                        }
                    }
                }
            }
        }

        return index == n ? sortedItems : new int[0];
    }

    private List<Integer>[] constructGroups(int n, int[] group) {
        List<Integer>[] groups = new List[n];

        int index = n - 1;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1)
                group[i] = index--;

            if (groups[group[i]] == null)
                groups[group[i]] = new ArrayList<>();

            groups[group[i]].add(i);
        }

        return groups;
    }

    private List<Integer>[] constructGraph(int n, int[] group, List<List<Integer>> beforeItems) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            for (int j : beforeItems.get(i)) {
                if (graph[j] == null)
                    graph[j] = new ArrayList<>();

                graph[j].add(i);
                itemIndegrees[i]++;

                if (group[i] != group[j])
                    groupIndegrees[group[i]]++;
            }
        }

        return graph;
    }
}
