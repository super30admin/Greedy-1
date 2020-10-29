    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/candy/
    Time Complexity for operators : o(3n) .. n is the length of the nums array
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */ 
class Solution {
    public int candy(int[] ratings) {
        
        if(ratings ==  null || ratings.length == 0){
            return 0;
        }
        
        int result[] =  new int[ratings.length];
        
        Arrays.fill(result, 1);
        
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }     
        
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1]+1);
            }
        }
        
        int output = 0;
        for(int n: result){
            output += n;
        }
        
        return output;
    }
}