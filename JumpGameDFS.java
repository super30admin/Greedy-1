// TC: exponential
// SC: O(n)

class Solution {
    HashSet<Integer> visited;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return true;
        }
        visited = new HashSet<>();
        return dfs(nums, 0);
    }
    private boolean dfs(int[] nums, int start) {
        if(visited.contains(start)) {
            return false;
        }

        if(start == nums.length - 1) {
            return true;
        }

        visited.add(start);
        for(int j = 1; j <= nums[start]; j++) {
            if(dfs(nums, start + j)) {
                return true;
            }
        }
        return false;
    }
}