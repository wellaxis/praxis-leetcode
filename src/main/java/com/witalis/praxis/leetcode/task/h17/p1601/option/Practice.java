package com.witalis.praxis.leetcode.task.h17.p1601.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1601
 * Name: Maximum Number of Achievable Transfer Requests
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/">Maximum Number of Achievable Transfer Requests</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int allBuildings;
    private int[][] requests;

    public Practice(int buildings, int[][] requests) {
        this.allBuildings = buildings;
        this.requests = requests;
    }

    public Integer process() {
        return maximumRequests(allBuildings, requests);
    }

    private int[] buildings;
    private int maxRequests;

    public int maximumRequests(int n, int[][] requests) {
        if (n <= 0 || requests == null) return 0;

        this.buildings = new int[n];
        this.maxRequests = 0;

        backtrack(requests, 0, 0);

        return maxRequests;
    }

    private void backtrack(int[][] requests, int index, int count) {
        if (index == requests.length) {
            for (int building : buildings) {
                if (building != 0) return;
            }
            maxRequests = Math.max(maxRequests, count);
            return;
        }

        int fromBuilding = requests[index][0];
        int toBuilding = requests[index][1];

        // prepare backtracking
        buildings[fromBuilding]--;
        buildings[toBuilding]++;

        // backtracking process
        backtrack(requests, index + 1, count + 1);

        // undo backtracking
        buildings[fromBuilding]++;
        buildings[toBuilding]--;

        // process the next request
        backtrack(requests, index + 1, count);
    }
}
