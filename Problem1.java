// Recursive Solution
// Time : O(n^n) - exponential - recursion tree
// Space : O(1)
// LeetCode: Time Limit Exceeded for last case

// Approach
// 1.start from index 0 and move 1 step and do this till it reaches end or move out of array.If it reaches end return true,else false.
// 2. Now from index 0 and move 1 more step than previous step and repeat above process till nums[0] steps. Do this for all subsequent
//   steps where we jump onto next index and return true if a solution is found

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <=1) return true;
        for(int i = 1;i<=nums[0];i++){
            if(helper(nums,0,i))    return true;
        }
        return false;
    }
    public boolean helper(int[] nums,int idx,int steps){
        if(idx+steps>=nums.length)  return false;
        if(idx+steps == nums.length-1)  return true;
        for(int i = 1;i<=nums[idx+steps];i++){
            if(helper(nums,idx+steps,i))    return true;
        }
        return false;
    }
}
