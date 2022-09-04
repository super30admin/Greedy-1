//Time Complexity: O(2^n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2_1 {

    int jumps = Integer.MAX_VALUE;
    int n = 0;
    
    public int jump(int[] nums) {
        
        n = nums.length;
        helper(nums,0,0);
        return jumps;
    }
    
    private void helper(int[] nums, int index, int jump)
    {
        if(index == n-1)
        {
            jumps = Math.min(jumps, jump);
            return;
        }
        
        if(index > n-1)
            return;
        
        for(int i =1; i <= nums[index]; i++)
        {
            helper(nums,index + i,jump +1);
        }
    }
}
