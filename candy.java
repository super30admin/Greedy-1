// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];
        
        Arrays.fill(result, 1);
        
        //left to right
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                result[i] = result[i-1]+1;
            }
        }
        int max = result[n-1];
        
        //right to left
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                result[i] = Math.max(result[i+1]+1, result[i]);   
            }
            max += result[i];
        }
        return max;
    }
}