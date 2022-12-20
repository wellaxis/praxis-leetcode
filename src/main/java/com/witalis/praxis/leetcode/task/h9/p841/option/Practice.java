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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<List<Integer>> rooms;

    public Boolean process() {
        return canVisitAllRooms(rooms);
    }

    enum State { INIT, VISITING, VISITED }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) return false;

        State[] visit = new State[rooms.size()];
        Arrays.fill(visit, State.INIT);
        recursiveVisit(rooms, visit, 0);

        return Arrays.stream(visit).allMatch(i -> i == State.VISITED);
    }

    public void recursiveVisit(List<List<Integer>> rooms, State[] visit, int index) {
        if (visit[index] != State.INIT) return;

        visit[index] = State.VISITING;
        rooms.get(index).forEach(key -> recursiveVisit(rooms, visit, key));
        visit[index] = State.VISITED;
    }
}
