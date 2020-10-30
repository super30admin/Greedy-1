    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/candy/
    Time Complexity for operators : o(3n) .. n is the length of the nums array
    Extra Space Complexity for operators : o(n) .. result array 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Create array result and fill 1 in each position as each person must have one candy.
                    B) Then start from Front and check ratings[i]>ratings[i-1] if it is then add 1 to the previous and change current
                        like result[i] = result[i-1] + 1;
                    C) Now, start from end, check ratings[i]>ratings[i+1] if it is then do below 
                       result[i] = Math.max(result[i], result[i+1]+1);
                    D) At the end, sum all the values from array and return the sum.
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