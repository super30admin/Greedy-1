//TIme Complexity : O(n) n is the numberof elements in ratings
//Space Complexity : O(1)
// LeetCode : passed all tests.



class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] arr = new int[n];
        int candy;
        int sum = n;
        for(int i = 1; i<n; i++){
            if(ratings[i-1]<ratings[i]){
                arr[i] = arr[i-1]+1;
            }
             
        }
        
         for(int i = n-1; i>0; i--){
            if(ratings[i-1]>ratings[i]){
                arr[i-1] = Math.max(arr[i-1],arr[i]+1);
            }
        }
        for(int i = 0;i<n;i++){
            sum+=arr[i];
        }
        
        return sum;
    }
}