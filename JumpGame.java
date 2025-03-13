/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Option 1: From back to front
 * 1. Check if the index can reach destination
 * 2. If it can, the new destination is the index
 * 3. Decrease the index and repeat step 1 to 3
 * 4. Eventually if index 0 is reached, that means, jump was possible to the end of array
 * 
 * Option 2: From front to back
 * 1. Check what the max jump can be performed (i + nums[i])
 * 2. If at any point check if index was greater than max destination that can be reached, that means, there is no way to reach index - i
 * 3. If eventually the index reached end of nums, it means jump was possible to the end of array. (max destination was reachable)
 */

public class JumpGame {
    // ------------------- Approach 1 - from back to front -------------------
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }

        int n = nums.length;
        int destination = n - 1;

        for (int i = n - 2; i >=0; i--) {
            if (i + nums[i] >= destination) {
                destination = i;
            }
        }

        return destination == 0;
    }

    // ------------------- Approach 2 - from front to back -------------------
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }

        int maxDestination = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxDestination) 
                return false;
            maxDestination = Math.max(maxDestination, i + nums[i]);
        }
        

        return true;
    }

    public static void main(String[] args) {
        // Your code here
    }
}
