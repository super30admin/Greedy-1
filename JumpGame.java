/*
 * TC = O(N)
 * SC = O(1)
 * 
 * Approach: We assume that we reach the end. 
 * Since the last jump is true, we try to find out if we can reach at every last jump.
 * 
 */

import java.util.*;
public class JumpGame
{

    public static boolean canJump(int[] nums)
    {
        int last = nums.length - 1;

        for(int i = last;i>=0;i--)
        {
            if(i+nums[i]>=last)
            {
                last = i;
            }
        }

        return last == 0;
    }

    public static void main(String args[])
    {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}