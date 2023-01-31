package com.witalis.praxis.leetcode.task.h17.p1626.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1626
 * Name: Best Team With No Conflicts
 * URL: <a href="https://leetcode.com/problems/best-team-with-no-conflicts/">Best Team With No Conflicts</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] scores;
    private int[] ages;

    public Integer process() {
        return bestTeamScore(scores, ages);
    }

    class Player implements Comparable<Player> {
        private int age;
        private int score;

        public Player(int age, int score) {
            this.age = age;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return age == player.age && score == player.score;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, score);
        }

        @Override
        public int compareTo(Player o) {
            int comparison = Integer.compare(score, o.score);
            return (comparison != 0) ? comparison : Integer.compare(age, o.age);
        }

        @Override
        public String toString() {
            return "Player[age=" + age + ", score=" + score + "]";
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        if (scores == null || ages == null || scores.length != ages.length) return 0;

        int n = scores.length;
        int[] dp = new int[n];

        List<Player> players = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            players.add(new Player(ages[i], scores[i]));
        }
        Collections.sort(players);

        for (int i = 0; i < n; i++) {
            Player current = players.get(i);
            dp[i] = current.score;
            for (int j = 0; j < i; j++) {
                Player previous = players.get(j);
                if (previous.age <= current.age) {
                    dp[i] = Math.max(dp[i], current.score + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(0);
    }
}
