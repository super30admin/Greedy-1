// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/jump-game/
// Any problem you faced while coding this : No


class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length<2) return true;
          HashSet<Integer> set = new HashSet<>();
          return dfs(nums,0,set);
    }

    private Boolean dfs(int[] nums, int idx, HashSet<Integer>set){
         //base
         if(idx==nums.length-1) return true;

         //logic
         set.add(idx);
         for(int j=1;j<=nums[idx];j++){
            int newIdx = idx+j;
            if(set.contains(newIdx)) continue;
            if(dfs(nums,newIdx,set)) return true;
         }
         return false;
    }
}
