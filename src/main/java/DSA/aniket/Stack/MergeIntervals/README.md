# Points to remember

- It will be solved using Stack
- Use Greedy Approach Sort the Array First
- `Arrays.sort(arr,(a,b)->a[0]-b[0])`
- and then check the current element with the element present inside the stack.

# Time Complexity O(NLogN)

- as we are Sorting it TC: `O(NLogN)`

# Space Complexity O(N)

- as we are Storing element in `Stack<int[]>`
- and size of the array is 2 N*2 = N
- so Overall TC : `O(N)`

# Solution

```java
class Solution {
    public void merge(int[][] intervals) {
        // Your code here, Print your output here
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> st = new Stack<>();
        for (int[] arr : intervals) {
            int a = arr[0];
            int b = arr[1];
            if (st.size() > 0) {
                if (st.peek()[1] < a) {
                    //as the starting value current is greater than the last value then it will make it's own interval
                    st.push(arr);
                } else {
                    //we have to merge
                    //as we sort this so it's easy
                    //lower will be less than the a
                    if (st.peek()[1] < b) {
                        //then we can replace last index with b
                        st.peek()[1] = b;
                    }
                }

            } else {
                st.push(arr);
            }
        }

        for (int[] arr : st) {
            System.out.println(arr[0] + " " + arr[1]);
        }


    }
}
```