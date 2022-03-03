// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        jump(nums);
    }

    public static int jump(int[] nums) {
        if(nums.length < 2)
            return 0;

        int jump = 1;

        int currInt = nums[0];
        int nextInt = nums[0];

        for(int i=1; i<nums.length; i++){ // T.C - O(N) ; S.C - O(1)
            nextInt = Math.max(nextInt, nums[i]+i);  // maintain the maximum jump from current point
            if(currInt >= nums.length-1) return jump; // if you reach the end , return number of jumps needed
            if(currInt == i){
                currInt = nextInt;
                jump++;
            }
        }

        return jump;
    }
}

