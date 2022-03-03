// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        canJump(nums);
    }

    public static boolean canJump(int[] nums) {
        //null case
        if(nums == null || nums.length == 0)
            return false;

        int n = nums.length;

        int destination = n-1;

        for(int i=n-2; i>=0; i--){  // T.C - O(N) ; S.C - O(1)
            if(i+nums[i] >= destination)  // index+element >= destinationIndex
                destination = i;
        }

        return destination==0;
    }
}

