// Time Complexity : exponential
// Space Complexity : O(n) as we are using a recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using DFS. In the dfs function pass nums[] and index. In the base condition check if index == nums.length -1, simply return true and if set already contains the index return false. Then start by adding the unique index in the queue and then run the for loop till nums[index] and calculate jump size. The again do dfs over new index.
 */
class Solution {
    Set<Integer> set;
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }

        set = new HashSet<>();
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int index){

        //base
        if(index == nums.length - 1){
            return true;
        }

        if(set.contains(index)){
            return false;
        }

        //logic
        set.add(index);
        for(int i = 1; i <= nums[index]; i++){
            int jump = index + i;

            if(dfs(nums, jump)){
                return true;
            }
        }

        return false;
    }
}