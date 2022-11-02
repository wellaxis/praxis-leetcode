# [LeetCode][leetcode] task # 433: [Minimum Genetic Mutation][task]

Description
-----------

> A gene string can be represented by an 8-character long string, with choices from `'A'`, `'C'`, `'G'`, and `'T'`.
> 
> Suppose we need to investigate a mutation from a gene string `start` to a gene string `end`
> where one mutation is defined as one single character changed in the gene string.
> * For example, `"AACCGGTT" --> "AACCGGTA"` is one mutation.
>
> There is also a gene bank `bank` that records all the valid gene mutations.
> A gene must be in `bank` to make it a valid gene string.
> 
> Given the two gene strings `start` and `end` and the gene bank `bank`,
> return _the minimum number of mutations needed to mutate from `start` to `end`_.
> If there is no such a mutation, return `-1`.
> 
> Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example
-------

```sh
Input: start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
Output: 3
```

Solution
--------

| Task | Solution                             |
|:----:|:-------------------------------------|
| 433  | [Minimum Genetic Mutation][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/minimum-genetic-mutation/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h5/p433/option/Practice.java>
