// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(ratings == null || n == 0) return 0;
        int[] result = new int[n];
        Arrays.fill(result,1);
        for(int i = 1 ; i < n ; i++){
            if(ratings[i] > ratings[i-1]) result[i] = result[i-1]+1;
        }
        for(int i = n-2 ; i >= 0 ; i--){
            if(ratings[i] > ratings[i+1] && result[i] <= result[i+1]) result[i] = result[i+1]+1;
        }
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum+= result[i];
        }
        return sum;
    }
}
