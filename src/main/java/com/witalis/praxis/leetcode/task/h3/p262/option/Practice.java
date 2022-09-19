package com.witalis.praxis.leetcode.task.h3.p262.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 262
 * Name: Trips and Users
 * URL: <a href="https://leetcode.com/problems/trips-and-users/">Trips and Users</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return usersTrips();
    }

    public String usersTrips() {
        return
            """

            SELECT t.request_at AS "Day",
                   ROUND(SUM(DECODE(t.status, 'completed', 0, 1)) / COUNT(t.id), 2) AS "Cancellation Rate"
            FROM   trips t
            WHERE  t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
            AND    NOT EXISTS (
                SELECT NULL
                FROM   users u
                WHERE  u.banned = 'Yes'
                AND    u.users_id IN (t.client_id, t.driver_id)
            )
            GROUP BY t.request_at
            ORDER BY t.request_at

            """;
    }
}
