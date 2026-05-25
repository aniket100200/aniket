# Word Ladder II

## Metadata

- **Difficulty:** Hard
- **Topics:** Graph, BFS, DFS, Backtracking, HashMap, Shortest Path

---

# Problem Description

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return all the shortest transformation
sequences from `beginWord` to `endWord`.

A transformation sequence from word `A` to word `B` is valid if:

- Only one letter can be changed at a time.
- Each transformed word must exist in `wordList`.

Return all shortest transformation sequences in any order.

---

# Input / Output Format

## Input

- `String beginWord`
    - The starting word.
- `String endWord`
    - The target word.
- `List<String> wordList`
    - A list containing valid dictionary words.

## Output

- `List<List<String>>`
    - All shortest transformation sequences from `beginWord` to `endWord`.

## Important Notes

- Every transformed word must exist in the dictionary.
- Each transformation changes exactly one character.
- All words have the same length.
- If no valid transformation exists, return an empty list.

---

# Examples

## Example 1

### Input

```text
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
```

**Output**

```text
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
```