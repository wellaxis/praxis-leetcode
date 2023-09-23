# [LeetCode][leetcode] task # 1048: [Longest String Chain][task]

Description
-----------

> You are given an array of `words` where each word consists of lowercase English letters.
> 
> `wordA` is a **predecessor** of `wordB` if and only if we can insert **exactly one** letter
> anywhere in `wordA` **without changing the order of the other characters** to make it equal to `wordB`.
> 
> * For example, `"abc"` is a **predecessor** of `"abac"`, while `"cba"` is not a **predecessor** of `"bcad"`.
>
> A **word chain** is a sequence of words `[word1, word2, ..., wordk]` with `k >= 1`,
> where `word1` is a **predecessor** of `word2`, `word2` is a **predecessor** of `word3`, and so on.
> A single word is trivially a **word chain** with `k == 1`.
> 
> Return _the **length** of the **longest possible word chain** with words chosen from the given list of `words`_.

Example
-------

```sh
Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
```

Solution
--------

| Task | Solution                         |
|:----:|:---------------------------------|
| 1048 | [Longest String Chain][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/longest-string-chain/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h11/p1048/option/Practice.java>
