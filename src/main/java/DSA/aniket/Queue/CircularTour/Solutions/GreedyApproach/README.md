# Points to remember

- It will be solved Greedy Approach
    - First find your answer does `exists or not.`
    - If it exists then find your answer start from each point
    - track the petrol left from previous petrol and distance.

# Time Complexity O(N)

- as we are traversing through the array
- so Overall Time Complexity will be `O(N)`

# Space Complexity O(1)

- as we are using we are not using extra [Auxilary](https://google.com?query=Auxilary) space.
- so Overall Space Complexity will be `O(1)`

# Solution

```java
class Solution {
    public int tour(int[] petrol, int[] distance) {
        // will greedily check  if the answer exists?
        int total = 0;
        int n = petrol.length;
        for (int i = 0; i < n; i++) {
            total += (petrol[i] - distance[i]);
        }

        if (total < 0) return -1;

        // here means answer does exit
        int pans = -1;
        int totalPetrolLeft = 0;
        for (int i = 0; i < n; i++) {
            int totalPetrol = totalPetrolLeft + petrol[i];
            int distanceToMove = distance[i];
            if (totalPetrol >= distanceToMove) {
                totalPetrolLeft = totalPetrol - distanceToMove;
                if (pans == -1) {
                    pans = i;
                }
            } else {
                pans = -1;
                totalPetrolLeft = 0;
            }
        }

        return pans;
    }
}
```