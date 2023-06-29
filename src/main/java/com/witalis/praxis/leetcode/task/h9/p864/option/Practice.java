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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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

        final int rows = grid.length;
        final int cols = grid[0].length();

        final Set<Character> keys = new HashSet<>();
        final Set<Character> locks = new HashSet<>();

        Cell start = null;
        final BitSet access = new BitSet(26);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                final char cell = grid[row].charAt(col);

                if (cell == '@') {
                    start = new Cell(row, col);
                } else if (Character.isLetter(cell)) {
                    if (Character.isLowerCase(cell)) {
                        keys.add(cell);
                        access.set(cell - 'a');
                    } else if (Character.isUpperCase(cell)) {
                        locks.add(cell);
                    }
                }
            }
        }

        if (start == null) return -1;

        final Queue<State> queue = new ArrayDeque<>();
        final Map<BitSet, Set<Cell>> seen = new HashMap<>();

        final BitSet initPermission = new BitSet(26);

        queue.offer(new State(initPermission, start, 0));
        seen.put(initPermission, new HashSet<>());
        seen.get(initPermission).add(start);

        while (!queue.isEmpty()) {
            final State state = queue.poll();

            for (Direction direction : Direction.values()) {
                final int row = state.position.row + direction.row;
                final int col = state.position.col + direction.col;

                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    final char cell = grid[row].charAt(col);
                    final int distance = state.distance;
                    final BitSet permission = state.permissions;

                    // wall
                    if (cell == '#') continue;

                    // lock
                    if (locks.contains(cell) && !permission.get(cell - 'A')) continue;

                    // key
                    if (keys.contains(cell)) {
                        if (permission.get(cell - 'a')) continue;

                        final BitSet nextPermission = (BitSet) permission.clone();
                        nextPermission.set(cell - 'a');

                        if (nextPermission.equals(access)) return distance + 1;

                        queue.offer(new State(nextPermission, new Cell(row, col), distance + 1));
                        seen.putIfAbsent(nextPermission, new HashSet<>());
                        seen.get(nextPermission).add(new Cell(row, col));
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
