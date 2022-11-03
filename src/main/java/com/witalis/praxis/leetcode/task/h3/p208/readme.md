# [LeetCode][leetcode] task # 208: [Implement Trie (Prefix Tree)][task]

Description
-----------

> A `trie` (pronounced as "try") or **prefix tree** is a tree data structure
> used to efficiently store and retrieve keys in a dataset of strings.
> There are various applications of this data structure, such as autocomplete and spellchecker.
> 
> Implement the Trie class:
> 
> * `Trie()` Initializes the trie object.
> * `void insert(String word)` Inserts the string `word` into the trie.
> * `boolean search(String word)` Returns `true` if the string word
> is in the trie (i.e., was inserted before), and `false` otherwise.
> * `boolean startsWith(String prefix)` Returns `true` if there is a previously
> inserted string `word` that has the prefix `prefix`, and `false` otherwise.

Example
-------

```sh
Input:
    ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output:
    [null, null, true, false, true, null, true]
Explanation:
    Trie trie = new Trie();
    trie.insert("apple");   // return void
    trie.search("apple");   // return true
    trie.search("app");     // return false
    trie.startsWith("app"); // return true
    trie.insert("app");     // return void
    trie.search("app");     // return true
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 208  | [Implement Trie (Prefix Tree)][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/implement-trie-prefix-tree/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h3/p208/option/Practice.java>
