package com.witalis.praxis.leetcode.task.h17.p1601.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1601
 * Name: Maximum Number of Achievable Transfer Requests
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/">Maximum Number of Achievable Transfer Requests</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int buildings;
    private int[][] requests;

    public Integer process() {
        return maximumRequests(buildings, requests);
    }

    public int maximumRequests(int n, int[][] requests) {
        if (n <= 0 || requests == null) return 0;

        final int[] buildings = new int[n];
        final int[] maxRequests = new int[] {0};

        backtrack(requests, buildings, maxRequests, 0, 0);

        return maxRequests[0];
    }

    private void backtrack(int[][] requests, int[] buildings, int[] maxRequests, int index, int count) {
        if (index == requests.length) {
            for (int building : buildings) {
                if (building != 0) return;
            }
            maxRequests[0] = Math.max(maxRequests[0], count);
            return;
        }

        int fromBuilding = requests[index][0];
        int toBuilding = requests[index][1];

        // prepare backtracking
        buildings[fromBuilding]--;
        buildings[toBuilding]++;

        // backtracking process
        backtrack(requests, buildings, maxRequests, index + 1, count + 1);

        // undo backtracking
        buildings[fromBuilding]++;
        buildings[toBuilding]--;

        // process the next request
        backtrack(requests, buildings, maxRequests, index + 1, count);
    }
}
