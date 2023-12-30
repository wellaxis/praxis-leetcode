# [LeetCode][leetcode] task # 1897: [Redistribute Characters to Make All Strings Equal][task]

Description
-----------

> You are given an array of strings `words` (**0-indexed**).
> 
> In one operation, pick two **distinct** indices `i` and `j`, where `words[i]`
> is a non-empty string, and move **any** character from `words[i]` to **any** position in `words[j]`.
> 
> Return _`true` if you can make every string in words **equal**
> using **any** number of operations, and `false` otherwise_.

Example
-------

```sh
Input: words = ["abc","aabc","bc"]
Output: true
Explanation: Move the first 'a' in words[1] to the front of words[2], to make words[1] = "abc" and words[2] = "abc".
    All the strings are now equal to "abc", so return true.
```

Solution
--------

| Task | Solution                                                      |
|:----:|:--------------------------------------------------------------|
| 1897 | [Redistribute Characters to Make All Strings Equal][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h19/p1897/option/Practice.java>
