// Approach : Brute Force approach (DFS) at every index of nums we have jump number of options to explore
// Time : O(n^n)
// Space : O(h) // recursion space 
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <2) return true;
        return dfs(nums,0);
    }

    private boolean dfs(int[] nums, int index){
        // base case
        if(index == nums.length-1) return true;

        // logic at every index
        for(int j=1;j<=nums[index];j++){
            if(dfs(nums,index+j)) return true;
        }
        return false;
    }
}

// Approach : Instead of being exhasutive of making all possible jumps at every index we will make the max jump from that index and 
// compare if it is greater than previous max. At any given point if your iterative index is greater than current max possible index then we cannot reach.
// Time :  O(n)
// Space : O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int maxPossibleDestinationIdx = 0;
        for(int i =0;i<nums.length;i++){
            if(i >maxPossibleDestinationIdx) return false;
            maxPossibleDestinationIdx = Math.max(maxPossibleDestinationIdx ,nums[i]+i);
        }
        return true;
    }
}

// Approach : We mark the last element of the array index as our intial destination and go in the backwards to check at every 
// index if the max jump lands to a destination greater than initial destination index then we make that jump's index as destination and continue...
// Time :  O(n)
// Space : O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        int n = nums.length;
        int destination = n - 1; // intial destination
        for (int i = n - 2; i >= 0; i--) {
            if ((nums[i] + i) >= destination) {
                // make your new destination
                destination = i;
            }
        }
        return (destination == 0);
    }
}