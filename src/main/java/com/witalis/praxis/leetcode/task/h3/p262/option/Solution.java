package com.witalis.praxis.leetcode.task.h3.p262.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 262
 * Name: Trips and Users
 * URL: <a href="https://leetcode.com/problems/trips-and-users/">Trips and Users</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return usersTrips();
    }

    public String usersTrips() {
        return
            """

            WITH q1 AS (
                SELECT u.users_id
                FROM   users u
                WHERE  u.banned = 'Yes'
            )
            SELECT t.request_at AS "Day",
                   ROUND(SUM(CASE WHEN t.status = 'completed' THEN 0 ELSE 1 END) / COUNT(*), 2) AS "Cancellation Rate"
            FROM   trips t
            WHERE  t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
            AND    t.client_id NOT IN (SELECT users_id FROM q1)
            AND    t.driver_id NOT IN (SELECT users_id FROM q1)
            GROUP BY t.request_at
            ORDER BY t.request_at

            """;
    }
}
