package com.witalis.praxis.leetcode.task.h3.p240.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 240
 * Name: Search a 2D Matrix II
 * URL: <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">Search a 2D Matrix II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] matrix;
    private int target;

    public Boolean process() {
        return searchMatrix(matrix, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 && n == 1) return matrix[m - 1][n - 1] == target;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) return false;

        return recursiveSearch(matrix, target, 0, 0, m - 1, n - 1);
    }

    private boolean recursiveSearch(int[][] matrix, int target, int minRow, int minCol, int maxRow, int maxCol) {
        if (maxRow < 0 || maxCol < 0) return false;

        if (minRow == maxRow) {
            for (int col = minCol; col <= maxCol; col++) {
                if (matrix[minRow][col] > target) break;
                if (matrix[minRow][col] == target) return true;
            }
        } else if (minCol == maxCol) {
            for (int row = minRow; row <= maxRow; row++) {
                if (matrix[row][minCol] > target) break;
                if (matrix[row][minCol] == target) return true;
            }
        } else {
            int _minRow = minRow;
            int _minCol = minCol;
            int _maxRow = maxRow;
            int _maxCol = maxCol;

            while (_minRow < _maxRow || _minCol < _maxCol) {
                int midRow = _minRow + (_maxRow - _minRow) / 2;
                int midCol = _minCol + (_maxCol - _minCol) / 2;
                if (matrix[midRow][midCol] == target) {
                    return true;
                } else if (matrix[midRow][midCol] > target) {
                    _maxRow = midRow;
                    _maxCol = midCol;
                } else {
                    if (_minRow < _maxRow) _minRow = midRow + 1;
                    if (_minCol < _maxCol) _minCol = midCol + 1;
                }
            }

            return matrix[_maxRow][_maxCol] == target
                || recursiveSearch(matrix, target, minRow, _maxCol, _maxRow - 1, maxCol)
                || recursiveSearch(matrix, target, _maxRow, minCol, maxRow, _maxCol - 1);
        }

        return false;
    }
}
