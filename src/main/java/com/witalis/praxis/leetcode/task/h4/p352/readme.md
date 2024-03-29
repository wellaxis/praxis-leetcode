# [LeetCode][leetcode] task # 352: [Data Stream as Disjoint Intervals][task]

Description
-----------

> Given a data stream input of non-negative integers `a1, a2, ..., an`,
> summarize the numbers seen so far as a list of disjoint intervals.
> 
> Implement the `SummaryRanges` class:
> * `SummaryRanges()` Initializes the object with an empty stream.
> * `void addNum(int value)` Adds the integer `value` to the stream.
> * `int[][] getIntervals()` Returns a summary of the integers in the stream currently
> as a list of disjoint intervals `[starti, endi]`. The answer should be sorted by `starti`.

Example
-------

```sh
Input
    ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
    [[], [1], [], [3], [], [7], [], [2], [], [6], []]
Output
    [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
Explanation
    SummaryRanges summaryRanges = new SummaryRanges();
    summaryRanges.addNum(1);      // arr = [1]
    summaryRanges.getIntervals(); // return [[1, 1]]
    summaryRanges.addNum(3);      // arr = [1, 3]
    summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
    summaryRanges.addNum(7);      // arr = [1, 3, 7]
    summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
    summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
    summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
    summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
    summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
```

Solution
--------

| Task | Solution                                      |
|:----:|:----------------------------------------------|
| 352  | [Data Stream as Disjoint Intervals][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/data-stream-as-disjoint-intervals/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h4/p352/option/Practice.java>
