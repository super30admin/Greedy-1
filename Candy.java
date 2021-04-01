/**

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104

Time Complexity: O(N)
Space Complexity : O(N)
is worked on Leetcode : YES

fill the output array with 1 to satisfy the 1st requirement of atleast one candy to everyone
// then one pass from start to end to update the candy count for left neighbour based on 2nd condition
// then one pass from end to start to udpate the candy output for right neighbour based on 2nd condition.
**/


class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int[] output = new int[ratings.length];
//         Assign one candy to every one to satisfy the 1st requirement
        Arrays.fill(output,1);
        int total=0;
//      left pass (left neighbour candy update)
        for(int i =1; i< ratings.length;i++) {
            
            if(ratings[i] > ratings[i-1]) {
                output[i] = output[i-1]+1;
            }
            
        }
        
//     right pass (right neighbour candy update)
        
        
        for(int i = ratings.length-2; i>=0 ;i-- ) {
            if(ratings[i] > ratings[i+1]) {
                output[i] = Math.max(output[i], output[i+1]+ 1);
                
            }
            
        }
        
        
        for(int cand : output) {
            total+= cand;
        }
        
        return total;
        
    }
}


