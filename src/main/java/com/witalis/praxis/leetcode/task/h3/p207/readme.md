# [LeetCode][leetcode] task # 207: [Course Schedule][task]

Description
-----------

> There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`.
> You are given an array `prerequisites` where `prerequisites[i] = [ai, bi]` indicates
> that you **must** take course `bi` first if you want to take course `ai`.
> 
> * For example, the pair [0, 1], indicates that to take course `0` you have to first take course `1`.
>
> Return `true` if you can finish all courses. Otherwise, return `false`.

Example
-------

```sh
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
    To take course 1 you should have finished course 0,
    and to take course 0 you should also have finished course 1.
    So it is impossible.
```

Solution
--------

| Task | Solution                    |
|:----:|:----------------------------|
| 207  | [Course Schedule][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/course-schedule/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h3/p207/option/Practice.java>
