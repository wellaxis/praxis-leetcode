package com.witalis.praxis.leetcode.task.h9.p841.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 841
 * Name: Keys and Rooms
 * URL: <a href="https://leetcode.com/problems/keys-and-rooms/">Keys and Rooms</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<List<Integer>> rooms;

    public Boolean process() {
        return canVisitAllRooms(rooms);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) return false;

        int[] visit = new int[rooms.size()];
        for (int i = 0; i < rooms.size(); i++) {
            if (visit[i] == 0) {
                List<Integer> keys = rooms.get(i);
                // recursive visiting...
            }
        }

        return Arrays.stream(visit).allMatch(i -> i == 1);
    }
}
