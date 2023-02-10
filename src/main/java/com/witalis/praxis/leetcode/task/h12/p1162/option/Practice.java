package com.witalis.praxis.leetcode.task.h12.p1162.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 200
 * Name: Number of Islands
 * URL: <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Integer process() {
        return maxDistance(grid);
    }

    static class Cell {
        int row;
        int col;
        boolean seen;
        Collection<Cell> neighbours;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
            this.seen = false;
            this.neighbours = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return row == cell.row && col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return String.format("Cell[%d,%d]", row, col);
        }
    }

    public int maxDistance(int[][] grid) {
        if (grid == null) return -1;

        int rows = grid.length;
        int cols = grid.length;

        final Queue<Cell> queue = new ArrayDeque<>();

        int sum = 0;
        Cell previous;
        final Cell[] line = new Cell[cols];
        for (int r = 0; r < rows; r++) {
            previous = null;
            for (int c = 0; c < cols; c++) {
                final Cell current = new Cell(r, c);

                if (r > 0) {
                    current.neighbours.add(line[c]);
                    line[c].neighbours.add(current);
                }
                if (c > 0) {
                    current.neighbours.add(previous);
                    previous.neighbours.add(current);
                }

                line[c] = current;
                previous = current;
                if (grid[r][c] == 1) {
                    current.seen = true;
                    queue.offer(current);
                }

                sum += grid[r][c];
            }
        }

        if (sum == 0 || sum == rows * cols) return -1;

        int distance = -1;
        while (!queue.isEmpty()) {
            int iterations = queue.size();
            while (iterations-- > 0) {
                Cell cell = queue.poll();
                for (Cell neighbour : cell.neighbours) {
                    if (!neighbour.seen) {
                        neighbour.seen = true;
                        queue.offer(neighbour);
                    }
                }
            }
            distance++;
        }

        return distance;
    }
}
