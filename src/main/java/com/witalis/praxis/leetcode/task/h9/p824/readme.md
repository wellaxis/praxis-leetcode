# [LeetCode][leetcode] task # 824: [Goat Latin][task]

Description
-----------

> You are given a string `sentence` that consist of words separated by spaces.
> Each word consists of lowercase and uppercase letters only.
> 
> We would like to convert the sentence to **"Goat Latin"** (a made-up language similar to Pig Latin.)
> The rules of Goat Latin are as follows:
> * If a word begins with a vowel (`'a'`, `'e'`, `'i'`, `'o'`, or `'u'`), append `"ma"` to the end of the word.
>   * For example, the word `"apple"` becomes `"applema"`.
> * If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add `"ma"`.
>   * For example, the word `"goat"` becomes `"oatgma"`.
> * Add one letter `'a'` to the end of each word per its word index in the sentence, starting with `1`.
>   * For example, the first word gets `"a"` added to the end, the second word gets `"aa"` added to the end, and so on.
>
> Return _the final sentence representing the conversion from sentence to **Goat Latin**_.

Example
-------

```sh
Input: sentence = "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
```

Solution
--------

| Task | Solution               |
|:----:|:-----------------------|
| 824  | [Goat Latin][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/goat-latin/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h9/p824/option/Practice.java>
