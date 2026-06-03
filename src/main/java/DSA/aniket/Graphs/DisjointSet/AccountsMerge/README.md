# Accounts Merge

## Metadata

- **Difficulty:** Medium
- **Topics:** Graphs, Depth First Search (DFS), Disjoint Set Union (DSU), Union-Find, HashMap, String Processing

---

## Problem Description

Given a list of accounts where each element `accounts[i]` is a list of strings, where:

- `accounts[i][0]` is the account holder's name.
- The rest of the elements are email addresses associated with that account.

Merge accounts that belong to the same person.

Two accounts definitely belong to the same person if there is at least one common email address between them.

After merging:

- The first element should be the person's name.
- The remaining elements should be all unique emails belonging to that person.
- Emails must be sorted lexicographically.
- The returned accounts can be in any order.

---

## Input / Output Format

### Input

- `List<List<String>> accounts`
    - `accounts[i][0]` = person's name
    - `accounts[i][j] (j >= 1)` = email address

### Output

- Return `List<List<String>>`
- Each merged account contains:
    - Name
    - Sorted unique emails

### Notes

- A person may have multiple accounts.
- Multiple accounts can be merged through shared emails.
- The same name may belong to different people.
- Output order is not important.
- Email addresses are unique identifiers.

---

## Examples

### Example 1

**Input**

```text
[
 ["John","johnsmith@mail.com","john_newyork@mail.com"],
 ["John","johnsmith@mail.com","john00@mail.com"],
 ["Mary","mary@mail.com"],
 ["John","johnnybravo@mail.com"]
]
```

**Output**

```text
[
 ["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
 ["Mary","mary@mail.com"],
 ["John","johnnybravo@mail.com"]
]
```

**Explanation**

The first two John's accounts share the email:

```text
johnsmith@mail.com
```

Therefore they belong to the same person and are merged.

---

### Example 2

**Input**

```text
[
 ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
 ["Kevin","Kevin3@m.co","Kevin5@m.co"],
 ["Gabe","Gabe3@m.co","Gabe2@m.co"]
]
```

**Output**

```text
[
 ["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe2@m.co","Gabe3@m.co"],
 ["Kevin","Kevin3@m.co","Kevin5@m.co"]
]
```

**Explanation**

Both Gabe accounts share:

```text
Gabe3@m.co
```

Thus they are merged.

---

### Example 3

**Input**

```text
[
 ["Alex","a@mail.com"],
 ["Alex","b@mail.com"]
]
```

**Output**

```text
[
 ["Alex","a@mail.com"],
 ["Alex","b@mail.com"]
]
```

**Explanation**

No common emails exist, so no merge occurs.

---

## Constraints

- `1 <= accounts.length <= 1000`
- `2 <= accounts[i].length <= 10`
- `1 <= accounts[i][j].length <= 30`
- Account names contain letters.
- Emails are valid email strings.
- Total number of emails ≤ 10,000.
- Expected Time Complexity: **O(N × α(N) + E log E)**
- Expected Auxiliary Space: **O(N + E)**

---

## Approach (DSU / Union-Find)

### Idea

Treat each account index as a node.

1. Traverse every email.
2. Map each email to the first account that contains it.
3. If the email appears again:
    - Union the two account indices.
4. After all unions:
    - Group emails by their DSU parent.
5. Sort emails within each group.
6. Build the final merged account list.

### Why DSU?

DSU efficiently identifies accounts that belong to the same connected component through shared emails.

Time complexity remains nearly linear due to path compression and union by size/rank.

---