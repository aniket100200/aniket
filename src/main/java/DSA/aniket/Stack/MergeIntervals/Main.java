package DSA.aniket.Stack.MergeIntervals;

import java.util.*;

class Solution {
    public void merge(int[][] intervals) {
        // Your code here, Print your output here
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Stack<int[]>st=new Stack<>();
        for(int[]arr:intervals){
            int a=arr[0];
            int b=arr[1];
            if(st.size()>0){
                if(st.peek()[1]<a){
                    //as the starting value current is greater than the last value then it will make it's own interval
                    st.push(arr);
                }else{
                    //we have to merge
                    //as we sort this so it's easy
                    //lower will be less than the a
                    if(st.peek()[1]<b){
                        //then we can replace last index with b
                        st.peek()[1]=b;
                    }
                }

            }else{
                st.push(arr);
            }
        }

        for(int[]arr:st){
            System.out.println(arr[0]+" "+arr[1]);
        }



    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m;
        m = sc.nextInt();
        int[][] A = new int[m][2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 2; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        Obj.merge(A);

    }
}