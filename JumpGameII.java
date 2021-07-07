/*
 * #45. Jump Game II
 * 
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1. 1 <= nums.length <= 3 * 104
2. 0 <= nums[i] <= 105

 */

/*
 * Time Complexity: O (N) -> To traverse the given array
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.greedy1;

public class JumpGameII {
	public int jump(int[] nums) {
        
        // #1. Base condition
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        
        // #2. Initialize number of jumps, current interval, and next interval
        int jump = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        
        // #3. Traverse through the array to compute minimum number of jumps
        for(int x = 1; x < nums.length - 1; x++){
            
            // #3.1. Update the next interval if greater than previous value 
            nextInterval = (nums[x] + x) > nextInterval ? nums[x] + x : nextInterval;
            
            // #3.2. Increment the jump and change current interval to next interval
            
            // curent interval == x -> exhausted all jump options from a particular point, and current interval != last index -> In case of nums = [1,2], then only increment jump and assign next interval to current interval
            if(currInterval == x && currInterval != nums.length - 1){
                jump++;
                currInterval = nextInterval;
            }
            
            // #3.3. If currInterval is the last index or greater than that, meaning we have reached/pass the destination, no more jumps possible, break from the loop, no need to traverse other elements of array if destination can be reached before that
            if(currInterval >= nums.length - 1){
                break;
            }
            
        }
        
        return jump;
        
    }

}
