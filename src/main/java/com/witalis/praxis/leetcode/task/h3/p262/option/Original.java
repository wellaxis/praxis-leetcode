package com.witalis.praxis.leetcode.task.h3.p262.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 262
 * Name: Trips and Users
 * URL: <a href="https://leetcode.com/problems/trips-and-users/">Trips and Users</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

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
            AND    t.client_id NOT IN (SELECT u.users_id FROM users u WHERE u.banned = 'Yes')
            AND    t.driver_id NOT IN (SELECT u.users_id FROM users u WHERE u.banned = 'Yes')
            GROUP BY t.request_at
            ORDER BY t.request_at

            """;
    }
}
