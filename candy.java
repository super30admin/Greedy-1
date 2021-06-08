// Time Complexity : O(3n) ,  n for left iteration; n for right iteration and another n for updating output 'a'
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        
        int n = ratings.length;
        int[] candy = new int[n]; //candy array
        Arrays.fill(candy,1); //fill it with 1
        
        //left iter
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] =candy[i-1]+1;
            }
        }
        
        //right iter
        int a = candy[n-1];
        
        for(int i = n - 2; i >= 0;i--){
            if(ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i], candy[i+1] + 1);
            }
            a += candy[i];
        }
        
        //output
//         int ans = 0;
//         for(int c : candy){
//             ans += c;
//         }
        
        return a;
    }
}