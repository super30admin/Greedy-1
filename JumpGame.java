/*
 * #55. Jump Game
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1. 1 <= nums.length <= 3 * 10^4
2. 0 <= nums[i][j] <= 10^5

 */

/*
 * Time Complexity: O (N) -> To traverse the array
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.greedy1;

public class JumpGame {
	public boolean canJump(int[] nums) {
        
        // #1. Base condition
		// If given array is null or only one element is given, means we can reach destination, return true
        if(nums == null || nums.length == 0 || nums.length == 1){
            return true;
        }
        
        /*
        *   If we start from 0th index as our start point, we will end up exploring the possible paths to reach to end/destination
        *   So, we will start from end as a starting point -> destination, and have a pointer at destination-1 position to see if we can reach destination from that position, if yes, then that pointer becomes a new destination, and decrement the pointer, repeat the above process until we reach the 0th index -> destination is at 0th index or a pointer say 'curr' becomes -1, outOfBounds. If destination at 0th index, meaning we are able to reach to our destination if we start from backward direction or from 0th index
        */
        // #2. Point the destination to last index and curr position to second last index
        int destination = nums.length - 1;
        int curr = nums.length - 2;
        
        // #3. Traverse the 'nums' array
        /*
        *   We will traverse until 'curr' position goes out of bounds while decrementing
        */
        while(curr >= 0){
            
            // We are checking, Max position I can go from curr position after taking max steps/jumps allowed at curr position
            // If the Max position I can go is at destination(index) or pass the destination(index > destination), then current 'curr' position will be my new destination and curr-- will be my new 'curr' position
            // If from a current 'curr' position, I cannot reach or pass the current 'destination', 'destination' will not change, just the 'curr' position will be decremented 
            if(curr + nums[curr] >= destination){
                destination = curr;
            }
            
            curr--;
        }
        
        // If we are at 0th index after exiting while loop, meaning we can reach to our destination, return true, else, return false
        return destination == 0;
        
    }
    
}
