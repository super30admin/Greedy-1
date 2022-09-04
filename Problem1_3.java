//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem1_3 {

    public boolean canJump(int[] nums)
    {
        int n = nums.length;
        int destination = n-1;
        
        for(int i = n-2; i>=0; i--)
        {
            if(i + nums[i] >= destination)
                destination = i;
        }
        
        return destination == 0;
    }
}
