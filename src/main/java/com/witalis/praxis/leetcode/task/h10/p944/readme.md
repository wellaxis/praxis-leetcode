# [LeetCode][leetcode] task # 944: [Delete Columns to Make Sorted][task]

Description
-----------

> You are given an array of `n` strings `strs`, all of the same length.
> 
> The strings can be arranged such that there is one on each line, making a grid.
> For example, `strs = ["abc", "bce", "cae"]` can be arranged as:
> ```
> abc
> bce
> cae
> ```
> You want to **delete** the columns that are **not sorted lexicographically**.
> In the above example (0-indexed), columns 0 (`'a'`, `'b'`, `'c'`) and 2 (`'c'`, `'e'`, `'e'`) are sorted
> while column 1 (`'b'`, `'c'`, `'a'`) is not, so you would delete column 1.
> 
> Return _the number of columns that you will delete_.

Example
-------

```sh
Input: strs = ["cba","daf","ghi"]
Output: 1
Explanation: The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
```

Solution
--------

| Task | Solution                                  |
|:----:|:------------------------------------------|
| 944  | [Delete Columns to Make Sorted][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/delete-columns-to-make-sorted/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h10/p944/option/Practice.java>
