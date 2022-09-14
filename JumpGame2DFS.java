// Time Complexity : O(n ^ n)
// Space Complexity : O(n ^ n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

//Traverse over all possible jumps from an element and recursively call dfs with the new index (for every jump)
//If the last element could be reached, keep track of min jumps used to reach the last element.
class JumpGameDFS {
    int min;
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;

        min = Integer.MAX_VALUE;

        dfs(nums, 0, 0);
        return min;
    }

    public void dfs(int[] nums, int index, int jumps) {
        //base case
        if(index == nums.length-1) {
            min = Math.min(min, jumps);
            return;
        }

        if(index >= nums.length) {
            return;
        }

        //logic
        for(int i = 1; i <= nums[index]; i++) {
            int newIndex = i + index;
            dfs(nums, newIndex, jumps+1);
        }
    }
}