# [LeetCode][leetcode] task # 2244: [Minimum Rounds to Complete All Tasks][task]

Description
-----------

> You are given a **0-indexed** integer array `tasks`, where `tasks[i]` represents the difficulty level of a task.
> In each round, you can complete either 2 or 3 tasks of the **same difficulty level**.
> 
> Return _the **minimum** rounds required to complete all the tasks,
> or `-1` if it is not possible to complete all the tasks_.

Example
-------

```sh
Input: tasks = [2,2,3,3,2,4,4,4,4,4]
Output: 4
Explanation: To complete all the tasks, a possible plan is:
- In the first round, you complete 3 tasks of difficulty level 2. 
- In the second round, you complete 2 tasks of difficulty level 3. 
- In the third round, you complete 3 tasks of difficulty level 4. 
- In the fourth round, you complete 2 tasks of difficulty level 4.  
It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.
```

Solution
--------

| Task | Solution                                         |
|:----:|:-------------------------------------------------|
| 2244 | [Minimum Rounds to Complete All Tasks][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h23/p2244/option/Practice.java>
