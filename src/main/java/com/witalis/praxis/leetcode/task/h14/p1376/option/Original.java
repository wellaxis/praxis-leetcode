package com.witalis.praxis.leetcode.task.h14.p1376.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 1376
 * Name: Time Needed to Inform All Employees
 * URL: <a href="https://leetcode.com/problems/time-needed-to-inform-all-employees/">Time Needed to Inform All Employees</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int employees;
    private int headIdentifier;
    private int[] managers;
    private int[] informTimes;

    public Integer process() {
        return numOfMinutes(employees, headIdentifier, managers, informTimes);
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n <= 0 || headID < 0 || manager == null || informTime == null) return 0;

        final Map<Integer, List<Integer>> company = new HashMap<>();
        for (int i = -1; i < n; i++)
            company.put(i, new ArrayList<>());
        for (int i = 0; i < n; i++)
            company.get(manager[i]).add(i);

        return dfs(company, informTime, headID);
    }

    private int dfs(Map<Integer, List<Integer>> company, int[] times, int manager) {
        if (company.get(manager).isEmpty()) return 0;

        int minutes = times[manager];
        for (int subordinate : company.get(manager)) {
            minutes += dfs(company, times, subordinate);
        }

        return minutes;
    }
}
