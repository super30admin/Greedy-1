/* Time Complexity : O(n*max)) 
 *  n - length of input array - nums 
 *  max - the max value in nums as the internal for loop would run that many times at the maximum */
/* Space Complexity : O(2n) ~ O(n) 
 *  size taken by the recursive stack and memoisation map */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//DFS

class Solution {
    HashMap<Integer, Integer> memoMap;
    public int jump(int[] nums) {
        this.memoMap = new HashMap<>();
        int n = nums.length;
        if(n == 1) return 0;
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int idx){
        //base condn
        if(memoMap.containsKey(idx)) return memoMap.get(idx);
        if(idx >= nums.length - 1) return 0;
        //logic
        int min = Integer.MAX_VALUE-5;
        for(int j = 1; j <= nums[idx]; j++){
            int child = idx + j;
            int temp = dfs(nums, child);
            min = Math.min(min, temp);
        }
        memoMap.put(idx, min + 1);
        return min + 1;
    }
}