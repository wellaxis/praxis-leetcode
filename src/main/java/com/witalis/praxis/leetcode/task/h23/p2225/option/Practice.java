package com.witalis.praxis.leetcode.task.h23.p2225.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2225
 * Name: Find Players With Zero or One Losses
 * URL: <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/">Find Players With Zero or One Losses</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] matches;

    public List<List<Integer>> process() {
        return findWinners(matches);
    }

    static class Player {
        private final int id;
        private int wins;
        private int losses;

        public Player(int id) {
            this.id = id;
        }
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        if (matches == null) return Collections.emptyList();

        Map<Integer, Player> players = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            players.putIfAbsent(winner, new Player(winner));
            players.get(winner).wins++;
            players.putIfAbsent(loser, new Player(loser));
            players.get(loser).losses++;
        }

        List<Integer> notLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();
        players.values().forEach(
            player -> {
                if (player.wins > 0 && player.losses == 0) notLost.add(player.id);
                if (player.losses == 1) oneLost.add(player.id);
            }
        );
        notLost.sort(Comparator.naturalOrder());
        oneLost.sort(Comparator.naturalOrder());

        return List.of(notLost, oneLost);
    }
}
