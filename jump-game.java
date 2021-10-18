//TC: exponential, because for all the elements loop is running again and again
//SC: O(n)
//running on leetcode: yes
//DFS
class Solution {
    HashSet<Integer> set;
    public boolean canJump(int[] nums) {
        //if length < 2, array contains only one index, so already at the last index
        if (nums==null || nums.length<2) return true;
        //visited array of indices,
        set = new HashSet<>();
        return dfs(nums, 0);
    }
    private boolean dfs(int[] nums, int idx){
        //base case
        if(idx==nums.length-1) return true;
        if(set.contains(idx)) return false;
        //logic
        //add the index we are on to the set
        set.add(idx);
        //upper and lower limit of i are the jumps that can be taken
        for(int i=1; i<=nums[idx]; i++){
            //idx+i is the new index
            if(dfs(nums, idx+i)){
                return true;
            }
        }
        return false;
    }
}
