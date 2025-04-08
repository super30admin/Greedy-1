// Time Complexity: O(n^2) where n is the length of the array
// Space Complexity: O(n) for the set to store visited indices

import java.util.HashSet;
import java.util.Set;

class JumpGame1 {
    public boolean canJump(int[] nums) {
        if(nums.length < 2){
            return true;
        }

        Set<Integer> set = new HashSet<>();

        return dfs(0, nums, set);
    }

    private boolean dfs(int index, int[] nums, Set<Integer> set){
        // base
        if(index >= nums.length-1){
            return true;
        }

        if(set.contains(index)){
            return false;
        }

        // logic
        for(int i = 1; i <= nums[index]; i++){
            if(dfs(index+i, nums, set)){
                return true;
            }
        }
        set.add(index);
        return false;
    }

    // Greedy approach
    // Time Complexity: O(n)
    public boolean canJumpGreedy(int[] nums) {
        if(nums.length < 2){
            return true;
        }

        int n = nums.length;
        int target = n-1;
        for(int i = n-2; i >= 0; i--){
            if(i + nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
    }
}