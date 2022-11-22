# [LeetCode][leetcode] task # 341: [Flatten Nested List Iterator][task]

Description
-----------

> You are given a nested list of integers `nestedList`.
> Each element is either an integer or a list whose elements may also be integers or other lists.
> Implement an iterator to flatten it.
> 
> Implement the `NestedIterator` class:
> * `NestedIterator(List<NestedInteger> nestedList)` Initializes the iterator with the nested list `nestedList`.
> * `int next()` Returns the next integer in the nested list.
> * `boolean hasNext()` Returns `true` if there are still some integers in the nested list and `false` otherwise.
>
> Your code will be tested with the following pseudocode:
> ```
> initialize iterator with nestedList
> res = []
> while iterator.hasNext()
>     append iterator.next() to the end of res
> return res
> ```
>
> If `res` matches the expected flattened list, then your code will be judged as correct.

Example
-------

```sh
Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
    the order of elements returned by next should be: [1,1,2,1,1].
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 341  | [Flatten Nested List Iterator][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/flatten-nested-list-iterator/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h4/p341/option/Practice.java>
