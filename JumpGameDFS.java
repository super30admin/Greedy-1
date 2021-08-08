// Time Complexity : O(Exponential)
// Space Complexity : O(n)

class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean canJump(int[] nums) {
        if(nums.length < 2)
            return true;
        return dfs(0, nums, nums.length);
    }
    
    private boolean dfs(int idx, int[] nums, int n){
        //base
        if(visited.contains(idx))
            return false;
        if(idx == n - 1)
            return true;
        //logic
        visited.add(idx);
        for(int j = 1; j <= nums[idx]; j++){
            int newIdx = idx + j;
            if(dfs(newIdx, nums, n))
                return true;
        }
        return false;
    }
}