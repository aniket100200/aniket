# Points to remember

- Find two nearby indices.
    - eg. [2,3,4,7,11] and k=5
    -     [1,1,1,3,6] <- this are missing numbers
    - index 3 and 4 will be the indeces between the answer lie
    - element 7 and 11
    - and the answer is 9.

- It will be solved using

# Time Complexity O(N)

- as we are

# Space Complexity O(N)

- as we are

# Solution

``` text
    int missingNumber(int[]arr,int k){
        int low=0, high = n-1;

        while(low<=high){
            int mid = (low+high)/2;
            // missingCountTillIndex = arr[index] - (index+1)
            int missingNumberTillCurrentIndex = arr[mid] - (mid+1);
            if(missingNumberTillCurrentIndex>k)high=mid-1;
            else low=mid+1;
        }
        
        return low+k;
    }
    
    /**
    * Derivation for this low+k
    */
    
    //your Answer will be
    //      opposite polarity was possible answer but pointing to not possible number
    ans = arr[high] + (k-missingNumbersTillHigh)
        = arr[high]+(k-(arr[high]-(high+1)))
        = arr[high]+k-arr[high] + high+1;
        = 1+high + k;
        //as 1+high = low;
    ans = low + k;
        
    
        
```
