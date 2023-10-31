# [LeetCode][leetcode] task # 2433: [Find The Original Array of Prefix Xor][task]

Description
-----------

> You are given an integer array `pref` of size `n`. Find and return _the array `arr` of size `n` that satisfies:_
> * `pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]`.
> 
> Note that `^` denotes the **bitwise-xor** operation.
> 
> It can be proven that the answer is **unique**.

 Example
-------

```sh
Input: pref = [5,2,0,3,1]
Output: [5,7,2,3,2]
Explanation: From the array [5,7,2,3,2] we have the following:
    - pref[0] = 5.
    - pref[1] = 5 ^ 7 = 2.
    - pref[2] = 5 ^ 7 ^ 2 = 0.
    - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
    - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
```

Solution
--------

| Task | Solution                                          |
|:----:|:--------------------------------------------------|
| 2433 | [Find The Original Array of Prefix Xor][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/find-the-original-array-of-prefix-xor/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h25/p2433/option/Practice.java>
