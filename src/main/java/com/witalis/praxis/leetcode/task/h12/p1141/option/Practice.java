package com.witalis.praxis.leetcode.task.h12.p1141.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1141
 * Name: User Activity for the Past 30 Days I
 * URL: <a href="https://leetcode.com/problems/user-activity-for-the-past-30-days-i/">User Activity for the Past 30 Days I</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return pastUserActivities();
    }

    public String pastUserActivities() {
        return
            """

            SELECT TO_CHAR(a.activity_date, 'YYYY-MM-DD') AS day,
                   COUNT(DISTINCT a.user_id) AS active_users
            FROM   activity a,
                   (SELECT TO_DATE('2019-07-27', 'YYYY-MM-DD') AS threshold_date FROM dual) p
            WHERE  a.activity_date BETWEEN p.threshold_date - 29 AND p.threshold_date
            GROUP BY a.activity_date

            """;
    }
}
