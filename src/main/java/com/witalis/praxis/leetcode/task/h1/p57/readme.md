# [LeetCode][leetcode] task # 57: [Insert Interval][task]

Description
-----------

> You are given an array of non-overlapping intervals `intervals`
> where `intervals[i] = [starti, endi]` represent the start and the end
> of the `ith` interval and `intervals` is sorted in ascending order by `starti`.
> You are also given an interval `newInterval = [start, end]`
> that represents the start and end of another interval.
>
> Insert `newInterval` into `intervals` such that `intervals`
> is still sorted in ascending order by `starti` and `intervals`
> still does not have any overlapping intervals
> (merge overlapping intervals if necessary).
> 
> Return `intervals` _after the insertion_.

Example
-------

```sh
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```

Solution
--------

| Task | Solution                    |
|:----:|:----------------------------|
|  57  | [Insert Interval][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/insert-interval/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h1/p57/option/Practice.java>
