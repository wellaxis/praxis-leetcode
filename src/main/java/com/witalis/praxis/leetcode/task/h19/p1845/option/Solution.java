package com.witalis.praxis.leetcode.task.h19.p1845.option;

import com.witalis.praxis.leetcode.task.h19.p1845.content.ISeatManager;
import com.witalis.praxis.leetcode.task.h19.p1845.content.SeatManagerHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 1845
 * Name: Seat Reservation Manager
 * URL: <a href="https://leetcode.com/problems/seat-reservation-manager/">Seat Reservation Manager</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class SeatManager implements ISeatManager {
        private boolean[] res;
        private int min = 1;
        private int unreserved = 0;

        public SeatManager(int n) {
            this.res = new boolean[n + 1];
        }

        @Override
        public int reserve() {
            if (unreserved == 0) {
                res[min] = true;
                return min++;
            }

            for (int i = 1; i < res.length; i++) {
                if (!res[i]) {
                    res[i] = true;
                    unreserved--;
                    return i;
                }
            }

            return -1;
        }

        @Override
        public void unreserve(int seatNumber) {
            unreserved++;
            res[seatNumber] = false;
        }
    }

    public List<String> process() {
        return SeatManagerHandler.process(operations, new SeatManager(operations.get(0).getValue()));
    }
}
