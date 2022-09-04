//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2_3 {

    public int jump(int[] nums)
    {
        if(nums.length < 2)
            return 0;
        
        int n = nums.length;
        int jumps = 1;
        int curr = nums[0];
        int next = nums[0];
        
        for(int i =1; i<n; i++)
        {
            int idx = i + nums[i];
            
            next = Math.max(next,idx);
            
            if(i < n-1 && curr == i)
            {
                curr = next;
                jumps++;
            }   
        }
        return jumps;
    }
}
