public class Solution
	{
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No 
        public int Jump(int[] nums)
        {
            int n = nums.Length;
            if (n == 1) return 0;
            int jumps = 1;
            int currInt = nums[0];
            int nextInt = nums[0];
            for(int i = 0; i < nums.Length; i++)
            {
                nextInt = Math.Max(nextInt, nums[i] + i);
                if(i == currInt && i != n - 1)
                {
                    jumps++;
                    currInt = nextInt;
                }
            }
            return jumps;
        }
}
