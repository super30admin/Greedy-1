// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We use DFS to recursively calculate in how many steps we can reach the last index
// 2: We use a HashMap to store the index along with the min steps required to reach that index
// 3: We use the minimum value of steps so far vs the minimum steps present in the HashMap to determine the number of steps required
class Solution {
    public int jump(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        if(n == 1) return 0;
        return dfs(nums, 0, map);

    }

    private int dfs(int[] nums, int idx, HashMap<Integer,Integer> map){
        // base
        if(idx >= nums.length-1) return 0;
        if(map.containsKey(idx)) return map.get(idx);

        // logic
        int min = Integer.MAX_VALUE - 5;
        for(int i = 1; i<=nums[idx]; i++){
            int newIdx = i + idx;
            min = Math.min(min, dfs(nums,newIdx,map));
        }
        map.put(idx, min +1 );
        return map.get(idx);
    }
}