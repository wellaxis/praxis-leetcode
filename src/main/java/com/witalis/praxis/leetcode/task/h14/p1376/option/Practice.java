package com.witalis.praxis.leetcode.task.h14.p1376.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1376
 * Name: Time Needed to Inform All Employees
 * URL: <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/">Time Needed to Inform All Employees</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int employees;
    private int headIdentifier;
    private int[] managers;
    private int[] informTimes;

    public Practice(int employees, int headIdentifier, int[] managers, int[] informTimes) {
        this.employees = employees;
        this.headIdentifier = headIdentifier;
        this.managers = managers;
        this.informTimes = informTimes;
    }

    public Integer process() {
        return numOfMinutes(employees, headIdentifier, managers, informTimes);
    }

    private Map<Integer, List<Integer>> company;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n <= 0 || headID < 0 || manager == null || informTime == null) return 0;

        this.company = new HashMap<>();
        company.put(-1, Collections.emptyList());
        for (int i = 0; i < n; i++)
            if (manager[i] != -1)
                company.computeIfAbsent(manager[i], employee -> new ArrayList<>()).add(i);

        return dfs(informTime, headID);
    }

    private int dfs(int[] times, int manager) {
        int minutes = 0;
        if (company.containsKey(manager)) {
            for (int subordinate : company.get(manager)) {
                minutes = Math.max(minutes, dfs(times, subordinate));
            }
        }

        return minutes + times[manager];
    }
}
