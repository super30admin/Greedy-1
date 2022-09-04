//Time Complexity: O(2^n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1_1 {
    int n;
    public boolean canJump(int[] nums) {
        
        n = nums.length;
        return helper(nums,0);
    }
    private boolean helper(int[] nums, int index)
    {
        if(index == n-1)
            return true;
        
        else if(index > n-1)
            return false;
        
        for(int i =1; i <= nums[index]; i++)
        {
            if(helper(nums,index + i))
                return true;
        }
        
        return false;
    }
}
