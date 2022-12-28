# [LeetCode][leetcode] task # 1962: [Remove Stones to Minimize the Total][task]

Description
-----------

> You are given a **0-indexed** integer array `piles`, where `piles[i]` represents
> the number of stones in the `i^th` pile, and an integer `k`.
> You should apply the following operation **exactly** `k` times:
> * Choose any `piles[i]` and **remove** `floor(piles[i] / 2)` stones from it.
>
> **Notice** that you can apply the operation on the **same** pile more than once.
> 
> Return _the **minimum** possible total number of stones remaining after applying the `k` operations_.
> 
> `floor(x)` is the **greatest** integer that is **smaller** than or **equal** to `x` (i.e., rounds `x` down).

 Example
-------

```sh
Input: piles = [4,3,6,7], k = 3
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [4,3,3,7].
- Apply the operation on pile 3. The resulting piles are [4,3,3,4].
- Apply the operation on pile 0. The resulting piles are [2,3,3,4].
The total number of stones in [2,3,3,4] is 12.
```

Solution
--------

| Task | Solution                                        |
|:----:|:------------------------------------------------|
| 1962 | [Remove Stones to Minimize the Total][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/remove-stones-to-minimize-the-total/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h20/p1962/option/Practice.java>
