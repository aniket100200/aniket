# Alien Dictionary

## Metadata

- **Difficulty:** Hard
- **Topics:** Graph, Topological Sort, BFS, DFS, Directed Graph

---

## Problem Description

There is a new alien language that uses the English lowercase alphabet, but the order of the characters is unknown.

You are given a sorted dictionary of words from this alien language. Your task is to determine a valid order of
characters in the language.

If there are multiple valid answers, return any one of them.

If the given dictionary is invalid (i.e., it is impossible to determine a valid character ordering), return an empty
string.

---

## Input / Output Format

### Input

- `String[] words`
    - Array of words sorted lexicographically according to the alien language.

### Output

- `String`
    - A valid ordering of characters in the alien language.
    - Return `""` if no valid ordering exists.

---

## Examples

### Example 1

#### Input

```text
words = ["wrt","wrf","er","ett","rftt"]
```

#### Output

```text
"wertf"
```

#### Explanation

```text
From the dictionary order:
w -> e
r -> t
t -> f

A valid ordering is "wertf".
```

---

### Example 2

#### Input

```text
words = ["z","x"]
```

#### Output

```text
"zx"
```

#### Explanation

```text
The ordering rule is:
z -> x
```

---

### Example 3

#### Input

```text
words = ["z","x","z"]
```

#### Output

```text
""
```

#### Explanation

```text
The dictionary creates a cycle:
z -> x
x -> z

Hence, no valid ordering exists.
```

---

## Constraints

- `1 <= words.length <= 100`
- `1 <= words[i].length <= 100`
- Words consist of lowercase English letters.
- The input words are sorted according to the rules of the alien language.