public class Solution
	{
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No 
        public bool CanJump(int[] nums)
        {
            if (nums.Length == 1) return true;
            int target = nums.Length - 1;
            for(int i = nums.Length - 2; i >= 0; i--)
            {
                if (nums[i] + i >= target)
                    target = i;
            }
            
            return target == 0;
        }
}
