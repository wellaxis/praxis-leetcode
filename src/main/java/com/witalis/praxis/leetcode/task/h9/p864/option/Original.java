package com.witalis.praxis.leetcode.task.h9.p864.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 864
 * Name: Shortest Path to Get All Keys
 * URL: <a href="https://leetcode.com/problems/shortest-path-to-get-all-keys/">Shortest Path to Get All Keys</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] grid;

    public Integer process() {
        return shortestPathAllKeys(grid);
    }

    enum Direction {
        UP(-1, 0),
        DOWN(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private final int row;
        private final int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    record Cell (int row, int col) {}
    record State (BitSet permissions, Cell position, int distance) {}

    public int shortestPathAllKeys(String[] grid) {
        if (grid == null) return -1;

        int rows = grid.length;
        int cols = grid[0].length();

        Map<Character, Cell> keys = new HashMap<>();
        Map<Character, Cell> locks = new HashMap<>();

        Cell start = null;
        BitSet access = new BitSet(26);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cell = grid[row].charAt(col);

                if (cell == '@') {
                    start = new Cell(row, col);
                } else if (Character.isLetter(cell)) {
                    if (Character.isLowerCase(cell)) {
                        keys.put(cell, new Cell(row, col));
                        access.set(cell - 'a');
                    } else if (Character.isUpperCase(cell)) {
                        locks.put(cell, new Cell(row, col));
                    }
                }
            }
        }

        if (start == null) return -1;

        Queue<State> queue = new ArrayDeque<>();
        Map<BitSet, Set<Cell>> seen = new HashMap<>();

        BitSet initPermission = new BitSet(26);

        queue.offer(new State(initPermission, start, 0));
        seen.put(initPermission, new HashSet<>());
        seen.get(initPermission).add(start);

        while (!queue.isEmpty()) {
            State state = queue.poll();

            for (Direction direction : Direction.values()) {
                int row = state.position.row + direction.row;
                int col = state.position.col + direction.col;
                int distance = state.distance;
                BitSet permission = state.permissions;

                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    char cell = grid[row].charAt(col);

                    // wall
                    if (cell == '#') continue;

                    // key
                    if (keys.containsKey(cell)) {
                        if (permission.get(cell - 'a')) continue;

                        BitSet nextPermission = (BitSet) permission.clone();
                        nextPermission.set(cell - 'a');

                        if (nextPermission.equals(access)) return distance + 1;

                        queue.offer(new State(nextPermission, new Cell(row, col), distance + 1));
                        seen.putIfAbsent(nextPermission, new HashSet<>());
                        seen.get(nextPermission).add(new Cell(row, col));
                    }

                    // lock
                    if (locks.containsKey(cell)) {
                        if (!permission.get(cell - 'A')) continue;
                    }

                    // way
                    if (!seen.get(permission).contains(new Cell(row, col))) {
                        queue.offer(new State(permission, new Cell(row, col), distance + 1));
                        seen.get(permission).add(new Cell(row, col));
                    }
                }
            }
        }

        return -1;
    }
}
