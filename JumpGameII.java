/*
 * TC = O(N)
 * SC = O(N)
 * 
 * Approach: We try to perform the maximum jump possible from the particular index.
 */
public class JumpGameII {
    

    public static int jump(int[] nums)
    {
        if(nums == null || nums.length < 2) return 0;
        
        int jumps = 1;
        int curr = nums[0];
        int next = nums[0];

        for(int i=0;i<nums.length;i++)
        {
            next = Math.max(next, i + nums[i]);

            if(i<nums.length-1 && i == curr)
            {
                jumps++;
                curr=next;
            }
        }

        return jumps;
    }

    public static void main(String args[])
    {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
