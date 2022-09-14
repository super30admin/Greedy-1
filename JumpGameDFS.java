// Time Complexity : O(n ^ n)
// Space Complexity : O(n ^ n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Add the visited element to the set, then traverse over all possible jumps from that element and recursively call dfs with the new index (for every jump)
//If the last element is visited, return true
class JumpGameDFS {
    Set<Integer> visited;
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        //DFS
        visited = new HashSet<>();
        return dfs(nums, 0);
    }

    public boolean dfs(int[] nums, int index) {
        //base case
        if(index == nums.length-1) return true;
        if(visited.contains(index)) return false;
        //logic
        visited.add(index);
        for(int i=1; i<=nums[index]; i++) {
            if(dfs(nums, index+i)) {
                return true;
            }
        }
        return false;
    }
}