/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(1)
* 
*/
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int target = n - 1;

        for (int index = target - 1; index >= 0; index--) {
            if (index + nums[index] >= target) {
                target = index;
            }
        }

        return target == 0;
    }
}
