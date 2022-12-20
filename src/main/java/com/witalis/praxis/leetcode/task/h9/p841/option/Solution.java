package com.witalis.praxis.leetcode.task.h9.p841.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Stack;

/**
 * ID: 841
 * Name: Keys and Rooms
 * URL: <a href="https://leetcode.com/problems/keys-and-rooms/">Keys and Rooms</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<List<Integer>> rooms;

    public Boolean process() {
        return canVisitAllRooms(rooms);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int nei : rooms.get(node))
                if (!seen[nei]) {
                    seen[nei] = true;
                    stack.push(nei);
                }
        }

        for (boolean v : seen)
            if (!v) return false;

        return true;
    }
}
