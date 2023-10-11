package com.witalis.praxis.leetcode.task.h23.p2251.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 2251
 * Name: Number of Flowers in Full Bloom
 * URL: <a href="https://leetcode.com/problems/number-of-flowers-in-full-bloom/">Number of Flowers in Full Bloom</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] flowers;
    private int[] people;

    public int[] process() {
        return fullBloomFlowers(flowers, people);
    }

    enum EventType {
        S(1),
        P(2),
        E(3);

        private final int priority;

        EventType(int priority) {
            this.priority = priority;
        }
    }

    record Event(int period, EventType type, int position) {}

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        if (flowers == null || people == null) return new int[0];

        final int n = people.length;
        int[] answer = new int[n];

        Comparator<Event> byMinPeriod = Comparator.comparingInt(Event::period);
        Comparator<Event> byMinTypePriority = Comparator.comparingInt(e -> e.type().priority);
        Queue<Event> heap = new PriorityQueue<>(byMinPeriod.thenComparing(byMinTypePriority));

        for (int i = 0; i < n; i++) {
            int period = people[i];

            heap.offer(new Event(period, EventType.P, i));
        }

        for (int[] flower : flowers) {
            int start = flower[0];
            int end = flower[1];

            heap.offer(new Event(start, EventType.S, -1));
            heap.offer(new Event(end, EventType.E, -1));
        }

        int counter = 0;
        int persons = 0;
        while (persons < n && !heap.isEmpty()) {
            Event event = heap.poll();

            switch (event.type()) {
                case S -> counter++;
                case P -> {
                    int position = event.position();
                    answer[position] = counter;
                    persons++;
                }
                case E -> counter--;
            }
        }

        return answer;
    }
}
