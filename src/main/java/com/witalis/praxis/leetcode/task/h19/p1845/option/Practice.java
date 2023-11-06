package com.witalis.praxis.leetcode.task.h19.p1845.option;

import com.witalis.praxis.leetcode.task.h19.p1845.content.ISeatManager;
import com.witalis.praxis.leetcode.task.h19.p1845.content.SeatManagerHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;
import java.util.TreeSet;

/**
 * ID: 1845
 * Name: Seat Reservation Manager
 * URL: <a href="https://leetcode.com/problems/seat-reservation-manager/">Seat Reservation Manager</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public class SeatManager implements ISeatManager {
        private final TreeSet<Integer> seats;
        private final boolean[] occupied;

        public SeatManager(int n) {
            this.occupied = new boolean[n + 2];
            this.seats = new TreeSet<>();
            seats.add(1);
        }

        @Override
        public int reserve() {
            int seat = seats.first();
            occupied[seat] = true;
            seats.remove(seat);
            if (!occupied[seat + 1]) {
                seats.add(seat + 1);
            }
            return seat;
        }

        @Override
        public void unreserve(int seatNumber) {
            occupied[seatNumber] = false;
            seats.add(seatNumber);
        }
    }

    public List<String> process() {
        return SeatManagerHandler.process(operations, new SeatManager(operations.get(0).getValue()));
    }
}
