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
// Time : O(n) 
// Space : O(1)
// LeetCode: Yes

// Approach
// 1.Initially have finalpos as last index.Start from last before index and check if final position can be reached from this index
// 2.If it can be rached from this position then update finalpos to the current index , we need to check if this position can be reached 
//   from it's previous index. If it can't be reached then finalpos remains same and move on to the previous index of current index.
// 3. Finally if finalpos is index 0 i.e start position , then we reach final position , so return true else false.
     public boolean canJump2(int[] nums) {
        if(nums.length<=1)  return true;
        int finalpos = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(i+nums[i]>=finalpos) finalpos = i;
        }
        if(finalpos == 0)   return true;
        return false;
    }
}
