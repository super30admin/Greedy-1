// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We use DFS to recursively calculate whether we can reach the end target (end index)
// 2: We recursively calculate the new index using a for loop within the recursive block to determine whether we can reach the last index
// 3: We add each visited index to a set to avoid revisiting indexes that have been processed
class Solution {
    public boolean canJump(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length == 1) return true; // base case

        return dfs(nums, 0, set);
    }

    private boolean dfs(int[] nums, int idx, HashSet set){
        // base case
        if(idx == nums.length - 1) return true;
        if(set.contains(idx)) return false;

        // logic
        for(int i = 1; i<=nums[idx]; i++){
            int newIdx = i + idx;
            if(dfs(nums, newIdx, set)){
                return true;
            }
        }
        set.add(idx);
        return false;
    }
}