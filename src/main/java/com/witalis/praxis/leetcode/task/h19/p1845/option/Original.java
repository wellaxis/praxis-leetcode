package com.witalis.praxis.leetcode.task.h19.p1845.option;

import com.witalis.praxis.leetcode.task.h19.p1845.content.ISeatManager;
import com.witalis.praxis.leetcode.task.h19.p1845.content.SeatManagerHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1845
 * Name: Seat Reservation Manager
 * URL: <a href="https://leetcode.com/problems/seat-reservation-manager/">Seat Reservation Manager</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class SeatManager implements ISeatManager {
        private final Queue<Integer> heap;

        public SeatManager(int n) {
            this.heap = new PriorityQueue<>();
            for (int i = 1; i <= n; i++)
                heap.offer(i);
        }

        @Override
        public int reserve() {
            return (!heap.isEmpty()) ? heap.poll() : -1;
        }

        @Override
        public void unreserve(int seatNumber) {
            heap.offer(seatNumber);
        }
    }

    public List<String> process() {
        return SeatManagerHandler.process(operations, new SeatManager(operations.get(0).getValue()));
    }
}
